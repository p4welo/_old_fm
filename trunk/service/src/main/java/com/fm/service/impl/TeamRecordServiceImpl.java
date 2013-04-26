package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.ITeamRecordDao;
import com.fm.domain.*;
import com.fm.domain.comparator.TeamRecordComparator;
import com.fm.service.IMatchGameService;
import com.fm.service.ITeamRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: pawel
 * Date: 14.12.12
 * Time: 00:18
 */
@Service(TeamRecordServiceImpl.BEAN_NAME)
public class TeamRecordServiceImpl extends AbstractServiceImpl<TeamRecord> implements ITeamRecordService
{
   public static final String BEAN_NAME = "teamRecordService";

   @Resource
   private ITeamRecordDao teamRecordDao;

   @Resource
   private IMatchGameService matchGameService;

   @Override
   protected IAbstractDao<TeamRecord> getDao()
   {
      return (IAbstractDao<TeamRecord>) teamRecordDao;
   }

   @Override
   @Transactional
   public List<TeamRecord> findTeamRecordsBySeason(Season season, boolean orderByPlace)
   {
      return teamRecordDao.findTeamRecordsBySeason(season, orderByPlace);
   }

   @Override
   @Transactional
   public List<TeamRecord> simulateNextRound(Season season)
   {
      List<TeamRecord> oldRecords = findTeamRecordsBySeason(season, false);
      if (!CollectionUtils.isEmpty(oldRecords) && oldRecords.size() % 2 == 0)
      {
         List<TeamRecord> newRecords = new ArrayList<TeamRecord>();
         for (int i = 0; i < oldRecords.size(); i += 2)
         {
            TeamRecord hostRecord = oldRecords.get(i);
            TeamRecord guestRecord = oldRecords.get(i + 1);
            MatchGame matchGame = matchGameService.simulateMatch(hostRecord.getTeam(), guestRecord.getTeam(), season);

            TeamRecord newHostRecord = recalculateTeamRecord(hostRecord, matchGame, true);
            hostRecord.setObjectState(ObjectStateEnum.INACTIVE);
            update(hostRecord);

//            newHostRecord = save(newHostRecord);
            newRecords.add(newHostRecord);

            TeamRecord newGuestRecord = recalculateTeamRecord(guestRecord, matchGame, false);
            guestRecord.setObjectState(ObjectStateEnum.INACTIVE);
            update(guestRecord);

//            newGuestRecord = save(newGuestRecord);
            newRecords.add(newGuestRecord);
         }

         recalculatePlaces(newRecords);
         return newRecords;
      }
      return oldRecords;
   }

   @Override
   @Transactional
   public void recalculatePlaces(List<TeamRecord> newRecords)
   {
      Collections.sort(newRecords, new TeamRecordComparator());
      for (int i = newRecords.size(); i > 0; i--)
      {
         TeamRecord record = newRecords.get(i - 1);
         record.setPlace(i);
         record = save(record);
         newRecords.set(i - 1, record);
      }
   }

   @Override
   @Transactional
   public List<TeamRecord> findAllTeamRecordsFromSeason(Team team, Season season)
   {
      return teamRecordDao.findAllTeamRecordsFromSeason(team, season);
   }

   @Override
   @Transactional
   public TeamRecord recalculateTeamRecord(TeamRecord oldRecord, MatchGame matchGame, Boolean isHost)
   {
      WinTypeEnum winType;
      if (matchGame.getHostScores() == matchGame.getGuestScores())
      {
         winType = WinTypeEnum.DRAW;
      }
      else
      {
         winType = matchGame.getHostScores() > matchGame.getGuestScores() ?
                 WinTypeEnum.HOST_WIN : WinTypeEnum.GUEST_WIN;
      }

      TeamRecord newRecord = new TeamRecord();
      newRecord.setTeam(oldRecord.getTeam());
      newRecord.setTeamName(oldRecord.getTeamName());
      newRecord.setSeason(oldRecord.getSeason());
      newRecord.setRoundNumber(oldRecord.getRoundNumber() + 1);

      Integer pointsCount = oldRecord.getPointsCount();
      Integer winsCount = oldRecord.getWinsCount();
      Integer drawsCount = oldRecord.getDrawsCount();
      Integer losesCount = oldRecord.getLosesCount();
      if (winType == WinTypeEnum.DRAW)
      {
         pointsCount += 1;
         drawsCount++;
      }
      else if (isHost && winType == WinTypeEnum.HOST_WIN
              || !isHost && winType == WinTypeEnum.GUEST_WIN)
      {
         pointsCount += 3;
         winsCount++;
      }
      else
      {
         losesCount++;
      }
      newRecord.setPointsCount(pointsCount);
      newRecord.setWinsCount(winsCount);
      newRecord.setDrawsCount(drawsCount);
      newRecord.setLosesCount(losesCount);

      Integer goalsScored = oldRecord.getGoalsScored();
      goalsScored += isHost ? matchGame.getHostScores() : matchGame.getGuestScores();
      newRecord.setGoalsScored(goalsScored);

      Integer goalsAllowed = oldRecord.getGoalsAllowed();
      goalsAllowed += isHost ? matchGame.getGuestScores() : matchGame.getHostScores();
      newRecord.setGoalsAllowed(goalsAllowed);

      newRecord.setGoalsDifference(goalsScored - goalsAllowed);
      return newRecord;
   }
}
