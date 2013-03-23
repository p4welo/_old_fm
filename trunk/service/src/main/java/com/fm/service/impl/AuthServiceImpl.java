package com.fm.service.impl;

import com.fm.domain.UserEntity;
import com.fm.service.IAuthService;
import com.fm.service.IUserEntityService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * User: pawel
 * Date: 20.12.12
 * Time: 23:19
 */
@Service
public class AuthServiceImpl implements IAuthService
{
   @Resource
   private IUserEntityService userEntityService;

   @Transactional
   public UserEntity getLoggedInUserEntity()
   {
      User user = getLoggedInUser();
      return userEntityService.getByLogin(user.getUsername());
   }

   public User getLoggedInUser()
   {
      return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   }

   public boolean hasAuthority(String role)
   {
      User user = getLoggedInUser();
      Collection<GrantedAuthority> authorities = user.getAuthorities();
      for (GrantedAuthority authority : authorities)
      {
         if (role.equals(authority.getAuthority()))
         {
            return true;
         }
      }
      return false;
   }
}
