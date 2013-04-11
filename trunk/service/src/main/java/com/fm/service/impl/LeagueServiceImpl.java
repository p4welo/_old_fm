package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.ILeagueDao;
import com.fm.domain.League;
import com.fm.service.ILeagueService;
import com.fm.service.ISeasonService;
import com.fm.service.ITeamGenerationStrategy;
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
   private ITeamGenerationStrategy teamGenerationStrategy;

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
         teamGenerationStrategy.generate(league);
      }
      return league;
   }
}
