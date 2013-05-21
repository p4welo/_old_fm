package com.fm.dao.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.IUserDao;
import com.fm.dao.TestDomainObjectFactory;
import com.fm.domain.User;
import org.junit.Ignore;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 11.05.13
 * Time: 17:37
 * To change this template use File | Settings | File Templates.
 */
@Ignore
public class UserDaoImplTest extends IdentifiableDaoTest<User>
{
   @Resource
   private IUserDao userDao;

   @Override
   protected IAbstractDao<User> getDao()
   {
      return (IAbstractDao<User>) userDao;
   }

   @Override
   protected User getEntity()
   {
      return TestDomainObjectFactory.getUser();
   }

   @Override
   protected List<User> getEntities()
   {
      return Arrays.asList(getEntity());
   }
}
