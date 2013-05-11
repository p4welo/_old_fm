package com.fm.dao.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.INameDao;
import com.fm.dao.TestDomainObjectFactory;
import com.fm.domain.Name;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 11.05.13
 * Time: 14:37
 * To change this template use File | Settings | File Templates.
 */
public class NameDaoImplTest extends AbstractDaoTest<Name>
{
   @Resource
   private INameDao nameDao;

   @Override
   protected List<Name> getEntities()
   {
      return Arrays.asList(getEntity());
   }

   @Override
   protected IAbstractDao<Name> getDao()
   {
      return (IAbstractDao<Name>) nameDao;
   }

   @Override
   protected Name getEntity()
   {
      return TestDomainObjectFactory.getName();
   }
}
