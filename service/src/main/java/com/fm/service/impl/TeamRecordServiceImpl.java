package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.ITeamRecordDao;
import com.fm.domain.MatchGame;
import com.fm.domain.ObjectStateEnum;
import com.fm.domain.Season;
import com.fm.domain.TeamRecord;
import com.fm.service.IMatchGameService;
import com.fm.service.ITeamRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
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

   private void recalculatePlaces(List<TeamRecord> newRecords)
   {

   }

   @Override
   @Transactional
   public TeamRecord recalculateTeamRecord(TeamRecord oldRecord, MatchGame matchGame, Boolean isHost)
   {
      TeamRecord newRecord = new TeamRecord();
      newRecord.setTeam(oldRecord.getTeam());
      newRecord.setTeamName(oldRecord.getTeamName());
      newRecord.setSeason(oldRecord.getSeason());
      newRecord.setRoundNumber(oldRecord.getRoundNumber() + 1);

      Integer pointsCount = oldRecord.getPointsCount();
      if (matchGame.getHostScores() == matchGame.getGuestScores())
      {
         pointsCount += 1;
      }
      else if (isHost && matchGame.getHostScores() > matchGame.getGuestScores()
              || !isHost && matchGame.getHostScores() < matchGame.getGuestScores())
      {
         pointsCount += 3;
      }
      newRecord.setPointsCount(pointsCount);

      return newRecord;
   }
}
