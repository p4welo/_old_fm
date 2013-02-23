package com.football.manager.service.impl;

import com.football.manager.dao.IAbstractDao;
import com.football.manager.dao.IUserRoleDao;
import com.football.manager.domain.UserEntity;
import com.football.manager.domain.UserRole;
import com.football.manager.service.IUserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * UserEntity: pawel
 * Date: 17.12.12
 * Time: 19:41
 */
@Service(UserRoleServiceImpl.BEAN_NAME)
public class UserRoleServiceImpl extends AbstractServiceImpl<UserRole> implements IUserRoleService
{
   public static final String BEAN_NAME = "userRoleService";

   @Resource
   private IUserRoleDao userRoleDao;

   @Override
   protected IAbstractDao<UserRole> getDao()
   {
      return (IAbstractDao<UserRole>) userRoleDao;
   }

   @Override
   @Transactional
   public List<UserRole> getUserRoles(UserEntity userEntity)
   {
      return userRoleDao.getRolesByUser(userEntity);
   }

   @Override
   @Transactional
   public List<String> getRoles(UserEntity user)
   {
      List<String> roles = new ArrayList<String>();
      List<UserRole> userRoles = userRoleDao.getRolesByUser(user);
      if (userRoles != null)
      {
         for (UserRole userRole : userRoles)
         {
            roles.add(userRole.getRole());
         }
      }
      return roles;
   }
}
