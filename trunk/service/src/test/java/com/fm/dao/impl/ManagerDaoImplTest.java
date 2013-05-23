package com.fm.dao.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.IManagerDao;
import com.fm.dao.TestDomainObjectFactory;
import com.fm.domain.League;
import com.fm.domain.Manager;
import com.fm.domain.Team;
import com.fm.domain.User;
import org.junit.Before;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 11.05.13
 * Time: 17:23
 * To change this template use File | Settings | File Templates.
 */

public class ManagerDaoImplTest extends IdentifiableDaoTest<Manager>
{
   @Resource
   private IManagerDao managerDao;

   private League league;

   private Team team;

   private User user;

   @Before
   public void setup()
   {
      league = TestDomainObjectFactory.getLeague();
      persist(league);
      team = TestDomainObjectFactory.getTeam(league);
      persist(team);
      user = TestDomainObjectFactory.getUser();
      persist(user);
   }

   @Override
   protected IAbstractDao<Manager> getDao()
   {
      return managerDao;
   }

   @Override
   protected Manager getEntity()
   {
      return TestDomainObjectFactory.getManager(team, user);
   }

   @Override
   protected List<Manager> getEntities()
   {
      return Arrays.asList(getEntity());
   }
}
