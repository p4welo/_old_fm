package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.ISeasonDao;
import com.fm.domain.League;
import com.fm.domain.Season;
import com.fm.domain.Team;
import com.fm.domain.TeamRecord;
import com.fm.service.ISeasonService;
import com.fm.service.ITeamRecordService;
import com.fm.service.ITeamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserEntity: pawel
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
      return (IAbstractDao<Season>) seasonDao;
   }

   @Override
   @Transactional
   public Season save(Season season)
   {
      season.setNumber(seasonDao.getNextSeasonNumber(season.getLeague()));
      season = super.save(season);
      List<Team> teams = teamService.findTeamsFromLeague(season.getLeague());
      for (Team team : teams)
      {
         TeamRecord teamRecord = new TeamRecord();
         teamRecord.setSeason(season);
         teamRecord.setTeam(team);
         teamRecord.setTeamName(team.getName());
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
