package com.football.manager.service.impl;

import com.football.manager.dao.IAbstractDao;
import com.football.manager.dao.ISurnameDao;
import com.football.manager.domain.Surname;
import com.football.manager.service.ISurnameService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * UserEntity: pawel
 * Date: 01.12.12
 * Time: 00:24
 */
@Service(SurnameServiceImpl.BEAN_NAME)
public class SurnameServiceImpl extends AbstractServiceImpl<Surname> implements ISurnameService
{
   public static final String BEAN_NAME = "surnameService";

   @Resource
   private ISurnameDao surnameDao;

   @Override
   protected IAbstractDao<Surname> getDao()
   {
      return (IAbstractDao<Surname>) surnameDao;
   }
}
