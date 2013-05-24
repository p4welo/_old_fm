package com.fm.dao.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.IPlayerRatingDao;
import com.fm.dao.TestDomainObjectFactory;
import com.fm.domain.PlayerRating;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * User: pawel.radomski
 * Date: 24.05.13
 * Time: 13:48
 */
public class PlayerRatingServiceDaoImplTest extends IdentifiableDaoTest<PlayerRating>
{
   @Resource
   private IPlayerRatingDao playerRatingDao;

   @Override
   protected IAbstractDao<PlayerRating> getDao()
   {
      return playerRatingDao;
   }

   @Override
   protected PlayerRating getEntity()
   {
      return TestDomainObjectFactory.getPlayerRating();
   }

   @Override
   protected List<PlayerRating> getEntities()
   {
      return Arrays.asList(getEntity());
   }
}
