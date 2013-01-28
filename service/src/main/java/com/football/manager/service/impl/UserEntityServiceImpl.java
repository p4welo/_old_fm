package com.football.manager.service.impl;

import com.football.manager.dao.IAbstractDao;
import com.football.manager.dao.IUserEntityDao;
import com.football.manager.domain.UserEntity;
import com.football.manager.service.IUserEntityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * UserEntity: pawel
 * Date: 17.12.12
 * Time: 19:30
 */
@Service(UserEntityServiceImpl.BEAN_NAME)
public class UserEntityServiceImpl extends AbstractServiceImpl<UserEntity> implements IUserEntityService
{
   public static final String BEAN_NAME = "userEntityService";

   @Resource
   private IUserEntityDao userEntityDao;

   @Override
   protected IAbstractDao<UserEntity> getDao()
   {
      return (IAbstractDao<UserEntity>) userEntityDao;
   }

   public UserEntity findByLogin(String login)
   {
      return userEntityDao.findByLogin(login);
   }
}
