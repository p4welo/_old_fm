package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.IPlayerRatingDao;
import com.fm.domain.PlayerRating;
import com.fm.service.IPlayerRatingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * User: pawel.radomski
 * Date: 24.05.13
 * Time: 13:46
 */
@Service(PlayerRatingServiceImpl.BEAN_NAME)
public class PlayerRatingServiceImpl extends AbstractServiceImpl<PlayerRating> implements IPlayerRatingService
{
   public static final String BEAN_NAME = "playerRatingService";

   @Resource
   private IPlayerRatingDao playerRatingDao;

   @Override
   protected IAbstractDao<PlayerRating> getDao()
   {
      return playerRatingDao;
   }
}
