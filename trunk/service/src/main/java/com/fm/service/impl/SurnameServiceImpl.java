package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.ISurnameDao;
import com.fm.domain.Surname;
import com.fm.service.ISurnameService;
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
