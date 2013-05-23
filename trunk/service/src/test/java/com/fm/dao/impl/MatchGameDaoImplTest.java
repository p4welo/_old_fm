package com.fm.dao.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.IMatchGameDao;
import com.fm.dao.TestDomainObjectFactory;
import com.fm.domain.League;
import com.fm.domain.MatchGame;
import com.fm.domain.Season;
import org.junit.Before;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 11.05.13
 * Time: 17:29
 * To change this template use File | Settings | File Templates.
 */
public class MatchGameDaoImplTest extends IdentifiableDaoTest<MatchGame>
{
   @Resource
   private IMatchGameDao matchGameDao;

   private League league;

   private Season season;

   @Before
   public void setup()
   {
      league = TestDomainObjectFactory.getLeague();
      persist(league);
      season = TestDomainObjectFactory.getSeason(league);
      persist(season);
   }

   @Override
   protected IAbstractDao<MatchGame> getDao()
   {
      return matchGameDao;
   }

   @Override
   protected MatchGame getEntity()
   {
      return TestDomainObjectFactory.getMatchGame(season);
   }

   @Override
   protected List<MatchGame> getEntities()
   {
      return Arrays.asList(getEntity());
   }
}
