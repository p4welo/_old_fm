package com.football.manager.service.impl;

import com.football.manager.dao.IAbstractDao;
import com.football.manager.dao.INameDao;
import com.football.manager.domain.Name;
import com.football.manager.service.INameService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * UserEntity: pawel
 * Date: 01.12.12
 * Time: 00:24
 */
@Service
public class NameServiceImpl extends AbstractServiceImpl<Name> implements INameService
{
   @Resource
   private INameDao nameDao;

   @Override
   protected IAbstractDao<Name> getDao()
   {
      return (IAbstractDao<Name>) nameDao;
   }
}
