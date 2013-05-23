package com.fm.dao.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.ISeasonDao;
import com.fm.dao.TestDomainObjectFactory;
import com.fm.domain.League;
import com.fm.domain.Season;
import org.junit.Before;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 11.05.13
 * Time: 17:32
 * To change this template use File | Settings | File Templates.
 */
public class SeasonDaoImplTest extends IdentifiableDaoTest<Season>
{
   @Resource
   private ISeasonDao seasonDao;

   private League league;

   @Before
   public void setup()
   {
      league = TestDomainObjectFactory.getLeague();
      persist(league);
   }

   @Override
   protected IAbstractDao<Season> getDao()
   {
      return seasonDao;
   }

   @Override
   protected Season getEntity()
   {
      return TestDomainObjectFactory.getSeason(league);
   }

   @Override
   protected List<Season> getEntities()
   {
      return Arrays.asList(getEntity());
   }
}
