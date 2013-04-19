package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.IUserDao;
import com.fm.domain.User;
import com.fm.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * User: pawel
 * Date: 17.12.12
 * Time: 19:30
 */
@Service(UserServiceImpl.BEAN_NAME)
public class UserServiceImpl extends AbstractServiceImpl<User> implements IUserService
{
   public static final String BEAN_NAME = "userEntityService";

   @Resource
   private IUserDao userDao;

   @Override
   protected IAbstractDao<User> getDao()
   {
      return (IAbstractDao<User>) userDao;
   }

   @Override
   @Transactional
   public User getByLogin(String login)
   {
      return userDao.findByLogin(login);
   }

   @Override
   @Transactional
   public boolean authenticate(String login, String password)
   {
      User entity = userDao.authenticate(login, password);
      return entity != null;
   }
}