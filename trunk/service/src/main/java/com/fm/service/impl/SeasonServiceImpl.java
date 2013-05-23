package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.ISeasonDao;
import com.fm.domain.*;
import com.fm.service.ISeasonService;
import com.fm.service.ITeamRecordService;
import com.fm.service.ITeamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: pawel
 * Date: 14.12.12
 * Time: 00:03
 */
@Service(SeasonServiceImpl.BEAN_NAME)
public class SeasonServiceImpl extends AbstractServiceImpl<Season> implements ISeasonService
{
   public static final String BEAN_NAME = "seasonService";

   @Resource
   private ISeasonDao seasonDao;

   @Resource
   private ITeamService teamService;

   @Resource
   private ITeamRecordService teamRecordService;

   @Override
   protected IAbstractDao<Season> getDao()
   {
      return seasonDao;
   }

   @Override
   @Transactional
   public Season nextSeason(League league)
   {
      Season season = new Season();
      season.setLeague(league);

      Season oldSeason = seasonDao.getActiveSeason(league);
      if (oldSeason != null)
      {
         oldSeason.setObjectState(ObjectStateEnum.INACTIVE);
         update(oldSeason);

         season.setNumber(oldSeason.getNumber() + 1);
      }
      else
      {
         season.setNumber(1);
      }

      season.setObjectState(ObjectStateEnum.ACTIVE);
      season = save(season);

      List<Team> teams = teamService.findTeamsFromLeague(season.getLeague());
      for (int i = 0; i < teams.size(); i++)
      {
         TeamRecord teamRecord = new TeamRecord();
         teamRecord.setPlace(i + 1);
         teamRecord.setSeason(season);
         teamRecord.setTeamSid(teams.get(i).getSid());
         teamRecord.setTeamName(teams.get(i).getName());
         teamRecordService.save(teamRecord);
      }

      return season;
   }

   @Override
   @Transactional
   public Season getActiveSeason(League league)
   {
      return seasonDao.getActiveSeason(league);
   }

   @Override
   @Transactional
   public Season getSeasonByNumber(League league, int number)
   {
      return seasonDao.getSeasonByNumber(league, number);
   }

   @Override
   @Transactional
   public List<Season> getLeagueSeasons(League league)
   {
      return seasonDao.getLeagueSeasons(league);
   }
}
