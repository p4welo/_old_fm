package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.IPlayerStatsDao;
import com.fm.domain.PlayerStats;
import com.fm.service.IPlayerStatsService;
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
