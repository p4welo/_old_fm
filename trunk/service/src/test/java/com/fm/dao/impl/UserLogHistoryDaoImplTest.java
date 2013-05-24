package com.fm.dao.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.IUserLogHistoryDao;
import com.fm.dao.TestDomainObjectFactory;
import com.fm.domain.UserLogHistory;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * User: pawel.radomski
 * Date: 24.05.13
 * Time: 10:56
 */
public class UserLogHistoryDaoImplTest extends IdentifiableDaoTest<UserLogHistory>
{
   @Resource
   private IUserLogHistoryDao userLogHistoryDao;

   @Override
   protected IAbstractDao<UserLogHistory> getDao()
   {
      return userLogHistoryDao;
   }

   @Override
   protected UserLogHistory getEntity()
   {
      return TestDomainObjectFactory.getUserLogHistory();
   }

   @Override
   protected List<UserLogHistory> getEntities()
   {
      return Arrays.asList(getEntity());
   }
}
