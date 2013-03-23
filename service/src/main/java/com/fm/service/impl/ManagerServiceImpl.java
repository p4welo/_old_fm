package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.IManagerDao;
import com.fm.domain.Manager;
import com.fm.service.IManagerService;
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
