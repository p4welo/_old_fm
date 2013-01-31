package com.football.manager.service.impl;

import com.football.manager.dao.IAbstractDao;
import com.football.manager.dao.ISeasonDao;
import com.football.manager.domain.League;
import com.football.manager.domain.Season;
import com.football.manager.domain.Team;
import com.football.manager.domain.TeamRecord;
import com.football.manager.service.ISeasonService;
import com.football.manager.service.ITeamRecordService;
import com.football.manager.service.ITeamService;
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
}
