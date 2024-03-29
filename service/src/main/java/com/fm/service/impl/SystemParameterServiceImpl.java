package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.ISystemParameterDao;
import com.fm.domain.SystemParameter;
import com.fm.service.ISystemParameterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 15.04.13
 * Time: 18:08
 * To change this template use File | Settings | File Templates.
 */
@Service(SystemParameterServiceImpl.BEAN_NAME)
public class SystemParameterServiceImpl extends AbstractServiceImpl<SystemParameter> implements ISystemParameterService
{
   public static final String BEAN_NAME = "systemParameterService";

   @Resource
   private ISystemParameterDao systemParameterDao;

   @Override
   protected IAbstractDao<SystemParameter> getDao()
   {
      return systemParameterDao;
   }

   @Override
   @Transactional
   public String getByKey(String key)
   {
      return systemParameterDao.getByKey(key);
   }
}
