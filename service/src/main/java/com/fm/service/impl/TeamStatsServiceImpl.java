package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.ITeamStatsDao;
import com.fm.domain.TeamStats;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * User: pawel.radomski
 * Date: 24.05.13
 * Time: 16:43
 */
@Service(TeamStatsServiceImpl.BEAN_NAME)
public class TeamStatsServiceImpl extends AbstractServiceImpl<TeamStats>
{
   public static final String BEAN_NAME = "teamStatsService";

   @Resource
   private ITeamStatsDao teamStatsDao;

   @Override
   protected IAbstractDao<TeamStats> getDao()
   {
      return teamStatsDao;
   }
}
