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

/**
 * User: pawel
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
      return teamDao;
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

   @Override
   @Transactional
   public Long getNextId()
   {
      return teamDao.getNextId();
   }

   @Override
   @Transactional
   public Team findRandomCpuTeam()
   {
      return teamDao.findRandomCpuTeam();
   }
}
