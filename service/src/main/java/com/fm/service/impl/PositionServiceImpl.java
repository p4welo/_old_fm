package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.IPositionDao;
import com.fm.domain.Position;
import com.fm.service.IPositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * UserEntity: pawel
 * Date: 01.12.12
 * Time: 00:24
 */
@Service(PositionServiceImpl.BEAN_NAME)
public class PositionServiceImpl extends AbstractServiceImpl<Position> implements IPositionService
{
   public static final String BEAN_NAME = "positionService";

   @Resource
   private IPositionDao positionDao;

   @Override
   protected IAbstractDao<Position> getDao()
   {
      return (IAbstractDao<Position>) positionDao;
   }
}
