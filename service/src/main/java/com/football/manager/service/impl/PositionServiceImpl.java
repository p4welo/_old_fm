package com.football.manager.service.impl;

import com.football.manager.dao.IAbstractDao;
import com.football.manager.dao.IPositionDao;
import com.football.manager.domain.Position;
import com.football.manager.service.IPositionService;
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
