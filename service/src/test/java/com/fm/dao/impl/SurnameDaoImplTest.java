package com.fm.dao.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.ISurnameDao;
import com.fm.dao.TestDomainObjectFactory;
import com.fm.domain.Surname;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 11.05.13
 * Time: 15:19
 * To change this template use File | Settings | File Templates.
 */
public class SurnameDaoImplTest extends IdentifiableDaoTest<Surname>
{
   @Resource
   private ISurnameDao surnameDao;

   @Override
   protected IAbstractDao<Surname> getDao()
   {
      return (IAbstractDao<Surname>) surnameDao;
   }

   @Override
   protected Surname getEntity()
   {
      return TestDomainObjectFactory.getSurname();
   }

   @Override
   protected List<Surname> getEntities()
   {
      return Arrays.asList(getEntity());
   }
}
