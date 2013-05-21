package com.fm.dao.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.ITeamRecordDao;
import com.fm.dao.TestDomainObjectFactory;
import com.fm.domain.League;
import com.fm.domain.Season;
import com.fm.domain.Team;
import com.fm.domain.TeamRecord;
import org.junit.Before;
import org.junit.Ignore;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 11.05.13
 * Time: 17:36
 * To change this template use File | Settings | File Templates.
 */
@Ignore
public class TeamRecordDaoImplTest extends IdentifiableDaoTest<TeamRecord>
{
   @Resource
   private ITeamRecordDao teamRecordDao;

   private League league;

   private Season season;

   private Team team;

   @Before
   public void setup()
   {
      league = TestDomainObjectFactory.getLeague();
      persist(league);
      season = TestDomainObjectFactory.getSeason(league);
      persist(season);
      team = TestDomainObjectFactory.getTeam(league);
      persist(team);
   }

   @Override
   protected IAbstractDao<TeamRecord> getDao()
   {
      return (IAbstractDao<TeamRecord>) teamRecordDao;
   }

   @Override
   protected TeamRecord getEntity()
   {
      return TestDomainObjectFactory.getTeamRecord(team, season);
   }

   @Override
   protected List<TeamRecord> getEntities()
   {
      return Arrays.asList(getEntity());
   }
}
