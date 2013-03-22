package com.football.manager.security.service.impl;

import com.football.manager.domain.UserEntity;
import com.football.manager.domain.UserRole;
import com.football.manager.service.IUserEntityService;
import com.football.manager.service.IUserRoleService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService, InitializingBean
{
   @Resource
   private IUserEntityService userService;

   @Resource
   private IUserRoleService authorityService;

   @Override
   public void afterPropertiesSet() throws Exception
   {
      Assert.notNull(userService);
      Assert.notNull(authorityService);
   }

   @Override
   public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException
   {
      UserEntity user = userService.getByLogin(login);
      if (user == null)
      {
         throw new UsernameNotFoundException("user '" + login + "' not found!");
      }

      List<UserRole> authorities = authorityService.getUserRoles(user);
      Set<SimpleGrantedAuthority> roles = new HashSet<SimpleGrantedAuthority>();
      for (UserRole authority : authorities)
      {
         roles.add(new SimpleGrantedAuthority(authority.getRole()));
      }
      User result = new User(
              login,
              user.getPassword(),
              roles);
      return result;
   }

   public void setUserService(IUserEntityService userService)
   {
      this.userService = userService;
   }

   public void setAuthorityService(IUserRoleService authorityService)
   {
      this.authorityService = authorityService;
   }
}
