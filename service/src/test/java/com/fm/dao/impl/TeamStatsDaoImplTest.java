package com.fm.dao.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.ITeamStatsDao;
import com.fm.dao.TestDomainObjectFactory;
import com.fm.domain.TeamStats;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * User: pawel.radomski
 * Date: 24.05.13
 * Time: 16:45
 */
public class TeamStatsDaoImplTest extends IdentifiableDaoTest<TeamStats>
{
   @Resource
   private ITeamStatsDao teamStatsDao;

   @Override
   protected IAbstractDao<TeamStats> getDao()
   {
      return teamStatsDao;
   }

   @Override
   protected TeamStats getEntity()
   {
      return TestDomainObjectFactory.getTeamStats();
   }

   @Override
   protected List<TeamStats> getEntities()
   {
      return Arrays.asList(getEntity());
   }
}
