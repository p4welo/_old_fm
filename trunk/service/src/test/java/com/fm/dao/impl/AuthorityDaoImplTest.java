package com.fm.dao.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.IAuthorityDao;
import com.fm.dao.TestDomainObjectFactory;
import com.fm.domain.Authority;
import com.fm.domain.User;
import org.junit.Before;
import org.junit.Ignore;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 11.05.13
 * Time: 14:51
 * To change this template use File | Settings | File Templates.
 */
@Ignore
public class AuthorityDaoImplTest extends IdentifiableDaoTest<Authority>
{
   @Resource
   private IAuthorityDao authorityDao;

   private User user;

   @Before
   public void setup()
   {
      user = TestDomainObjectFactory.getUser();
      persist(user);
   }

   @Override
   protected List<Authority> getEntities()
   {
      return Arrays.asList(getEntity());
   }

   @Override
   protected IAbstractDao<Authority> getDao()
   {
      return (IAbstractDao<Authority>) authorityDao;
   }

   @Override
   protected Authority getEntity()
   {
      return TestDomainObjectFactory.getAuthority(user);
   }
}
