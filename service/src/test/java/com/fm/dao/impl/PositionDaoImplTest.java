package com.fm.dao.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.IPositionDao;
import com.fm.dao.TestDomainObjectFactory;
import com.fm.domain.Position;
import org.junit.Ignore;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 11.05.13
 * Time: 17:31
 * To change this template use File | Settings | File Templates.
 */
@Ignore
public class PositionDaoImplTest extends IdentifiableDaoTest<Position>
{
   @Resource
   private IPositionDao positionDao;

   @Override
   protected IAbstractDao<Position> getDao()
   {
      return (IAbstractDao<Position>) positionDao;
   }

   @Override
   protected Position getEntity()
   {
      return TestDomainObjectFactory.getPosition();
   }

   @Override
   protected List<Position> getEntities()
   {
      return Arrays.asList(getEntity());
   }
}
