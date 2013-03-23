package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.INameDao;
import com.fm.domain.Name;
import com.fm.service.INameService;
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
