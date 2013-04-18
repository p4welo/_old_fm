package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.IAuthorityDao;
import com.fm.domain.Authority;
import com.fm.domain.UserEntity;
import com.fm.service.IAuthorityService;
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
@Service(AuthorityServiceImpl.BEAN_NAME)
public class AuthorityServiceImpl extends AbstractServiceImpl<Authority> implements IAuthorityService
{
   public static final String BEAN_NAME = "userRoleService";

   @Resource
   private IAuthorityDao authorityDao;

   @Override
   protected IAbstractDao<Authority> getDao()
   {
      return (IAbstractDao<Authority>) authorityDao;
   }

   @Override
   @Transactional
   public List<Authority> getUserAuthorities(UserEntity userEntity)
   {
      return authorityDao.getAuthoritiesByUser(userEntity);
   }

   @Override
   @Transactional
   public List<String> getAuthorities(UserEntity user)
   {
      List<String> roles = new ArrayList<String>();
      List<Authority> authorities = authorityDao.getAuthoritiesByUser(user);
      if (authorities != null)
      {
         for (Authority userRole : authorities)
         {
            roles.add(userRole.getAuthority());
         }
      }
      return roles;
   }
}
