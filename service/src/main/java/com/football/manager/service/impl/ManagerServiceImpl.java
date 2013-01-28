package com.football.manager.service.impl;

import com.football.manager.dao.IAbstractDao;
import com.football.manager.dao.IManagerDao;
import com.football.manager.domain.Manager;
import com.football.manager.service.IManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * UserEntity: pawel
 * Date: 01.12.12
 * Time: 00:24
 */
@Service
public class ManagerServiceImpl extends AbstractServiceImpl<Manager> implements IManagerService
{
   @Resource
   private IManagerDao managerDao;

   @Override
   protected IAbstractDao getDao()
   {
      return (IAbstractDao) managerDao;
   }
}
