package com.football.manager.service.impl;

import com.football.manager.dao.IAbstractDao;
import com.football.manager.dao.ILeagueDao;
import com.football.manager.domain.League;
import com.football.manager.domain.Season;
import com.football.manager.service.ILeagueService;
import com.football.manager.service.ISeasonService;
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

   @Override
   protected IAbstractDao<League> getDao()
   {
      return (IAbstractDao<League>) leagueDao;
   }

   @Override
   @Transactional
   public League save(League league)
   {
      league = super.save(league);
      Season season = new Season();
      season.setNumber(1);
      season.setLeague(league);
      seasonService.save(season);
      return league;
   }
}
