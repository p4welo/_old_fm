package com.football.manager.service.impl;

import com.football.manager.dao.IAbstractDao;
import com.football.manager.dao.ITeamDao;
import com.football.manager.domain.League;
import com.football.manager.domain.Team;
import com.football.manager.service.ITeamService;
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
}
