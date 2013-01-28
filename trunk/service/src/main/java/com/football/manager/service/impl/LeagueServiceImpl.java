package com.football.manager.service.impl;

import com.football.manager.dao.IAbstractDao;
import com.football.manager.dao.ILeagueDao;
import com.football.manager.domain.League;
import com.football.manager.service.ILeagueService;
import org.springframework.stereotype.Service;

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

   @Override
   protected IAbstractDao<League> getDao()
   {
      return (IAbstractDao<League>) leagueDao;
   }
}
