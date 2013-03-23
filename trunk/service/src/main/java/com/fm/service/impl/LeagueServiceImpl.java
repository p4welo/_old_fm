package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.ILeagueDao;
import com.fm.domain.League;
import com.fm.domain.Team;
import com.fm.service.ILeagueService;
import com.fm.service.ISeasonService;
import com.fm.service.ITeamService;
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
