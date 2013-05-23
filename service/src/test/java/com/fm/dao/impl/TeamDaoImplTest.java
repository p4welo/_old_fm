package com.fm.dao.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.ITeamDao;
import com.fm.dao.TestDomainObjectFactory;
import com.fm.domain.League;
import com.fm.domain.Team;
import org.junit.Before;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 11.05.13
 * Time: 17:34
 * To change this template use File | Settings | File Templates.
 */
public class TeamDaoImplTest extends IdentifiableDaoTest<Team>
{
   @Resource
   private ITeamDao teamDao;

   private League league;

   @Before
   public void setup()
   {
      league = TestDomainObjectFactory.getLeague();
      persist(league);
   }

   @Override
   protected IAbstractDao<Team> getDao()
   {
      return teamDao;
   }

   @Override
   protected Team getEntity()
   {
      return TestDomainObjectFactory.getTeam(league);
   }

   @Override
   protected List<Team> getEntities()
   {
      return Arrays.asList(getEntity());
   }
}
