package com.football.manager.service.impl;

import com.football.manager.dao.IAbstractDao;
import com.football.manager.dao.IPlayerStatsDao;
import com.football.manager.domain.PlayerStats;
import com.football.manager.service.IPlayerStatsService;
import org.springframework.stereotype.Service;

/**
 * UserEntity: pawel
 * Date: 13.12.12
 * Time: 23:18
 */
@Service(PlayerStatsServiceImpl.BEAN_NAME)
public class PlayerStatsServiceImpl extends AbstractServiceImpl<PlayerStats> implements IPlayerStatsService
{
   public static final String BEAN_NAME = "playerStatsService";

   private IPlayerStatsDao playerStatsDao;

   @Override
   protected IAbstractDao<PlayerStats> getDao()
   {
      return (IAbstractDao<PlayerStats>) playerStatsDao;
   }
}
