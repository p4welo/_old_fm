package com.fm.dao.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.ILeagueDao;
import com.fm.dao.TestDomainObjectFactory;
import com.fm.domain.League;
import org.junit.Ignore;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 11.05.13
 * Time: 14:59
 * To change this template use File | Settings | File Templates.
 */
@Ignore
public class LeagueDaoImplTest extends IdentifiableDaoTest<League>
{
   @Resource
   private ILeagueDao leagueDao;

   @Override
   protected List<League> getEntities()
   {
      return Arrays.asList(getEntity());
   }

   @Override
   protected IAbstractDao<League> getDao()
   {
      return (IAbstractDao<League>) leagueDao;
   }

   @Override
   protected League getEntity()
   {
      return TestDomainObjectFactory.getLeague();
   }
}
