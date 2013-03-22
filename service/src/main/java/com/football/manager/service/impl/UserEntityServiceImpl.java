package com.football.manager.service.impl;

import com.football.manager.dao.IAbstractDao;
import com.football.manager.dao.IUserEntityDao;
import com.football.manager.domain.UserEntity;
import com.football.manager.service.IUserEntityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

   @Override
   @Transactional
   public UserEntity getByLogin(String login)
   {
      return userEntityDao.findByLogin(login);
   }

   @Override
   @Transactional
   public boolean authenticate(String login, String password)
   {
      UserEntity entity = userEntityDao.authenticate(login, password);
      return entity != null;
   }
}
