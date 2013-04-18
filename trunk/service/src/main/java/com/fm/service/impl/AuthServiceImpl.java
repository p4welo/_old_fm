package com.fm.service.impl;

import com.fm.domain.User;
import com.fm.service.IAuthService;
import com.fm.service.IUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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
   private IUserService userService;

   @Transactional
   public User getLoggedInUserEntity()
   {
      org.springframework.security.core.userdetails.User user = getLoggedInUser();
      return userService.getByLogin(user.getUsername());
   }

   public org.springframework.security.core.userdetails.User getLoggedInUser()
   {
      return (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication()
              .getPrincipal();
   }

   public boolean hasAuthority(String role)
   {
      org.springframework.security.core.userdetails.User user = getLoggedInUser();
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
