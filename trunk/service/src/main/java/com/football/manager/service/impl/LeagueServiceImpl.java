package com.football.manager.service.impl;

import com.football.manager.dao.IAbstractDao;
import com.football.manager.dao.ILeagueDao;
import com.football.manager.domain.League;
import com.football.manager.domain.Team;
import com.football.manager.service.ILeagueService;
import com.football.manager.service.ISeasonService;
import com.football.manager.service.ITeamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * UserEntity: pawel
 * Date: 13.12.12
 * Time: 23:09
 */
@Service
public class LeagueServiceImpl extends AbstractServiceImpl<League> implements ILeagueService
{
   @Resource
   private ILeagueDao leagueDao;

   @Resource
   private ISeasonService seasonService;

   @Resource
   private ITeamService teamService;

   @Override
   protected IAbstractDao<League> getDao()
   {
      return (IAbstractDao<League>) leagueDao;
   }

   @Override
   @Transactional
   public League save(League league, boolean generateTeams)
   {
      league = save(league);
      if (generateTeams)
      {
         for (int i = 0; i < 15; i++)
         {
            Team team = teamService.generate();
            team.setLeague(league);
            teamService.save(team);
         }
      }
//      Season season = new Season();
//      season.setNumber(1);
//      season.setLeague(league);
//      seasonService.save(season);
      return league;
   }
}
