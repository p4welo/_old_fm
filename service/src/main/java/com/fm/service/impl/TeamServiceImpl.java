package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.ITeamDao;
import com.fm.domain.League;
import com.fm.domain.Team;
import com.fm.service.ITeamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * UserEntity: pawel
 * Date: 01.12.12
 * Time: 00:24
 */
@Service(TeamServiceImpl.BEAN_NAME)
public class TeamServiceImpl extends AbstractServiceImpl<Team> implements ITeamService
{
   public static final String BEAN_NAME = "teamService";

   @Resource
   private ITeamDao teamDao;

   @Override
   protected IAbstractDao<Team> getDao()
   {
      return (IAbstractDao<Team>) teamDao;
   }

   @Override
   @Transactional
   public Team generate()
   {
      Random generator = new Random();

      Team team = new Team();

      team.setAccount(generator.nextInt(100));
      Long nextId = teamDao.getNextId();
      if (nextId != null)
      {
         team.setName("PC_" + String.valueOf(nextId));
      }
      else
      {
         team.setName("PC_First");
      }

      return team;
   }

   @Override
   @Transactional
   public List<Team> findTeamsFromLeague(League league)
   {
      return teamDao.findTeamsFromLeague(league);
   }

   @Override
   @Transactional
   public Integer getLeagueTeamsCount(League league)
   {
      return teamDao.getLeagueTeamsCount(league);
   }
}
