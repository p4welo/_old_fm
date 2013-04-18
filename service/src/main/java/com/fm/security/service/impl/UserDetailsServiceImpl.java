package com.fm.security.service.impl;

import com.fm.domain.Authority;
import com.fm.domain.User;
import com.fm.service.IAuthorityService;
import com.fm.service.IUserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService, InitializingBean
{
   @Resource
   private IUserService userService;

   @Resource
   private IAuthorityService authorityService;

   @Override
   public void afterPropertiesSet() throws Exception
   {
      Assert.notNull(userService);
      Assert.notNull(authorityService);
   }

   @Override
   public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException
   {
      User user = userService.getByLogin(login);
      if (user == null)
      {
         throw new UsernameNotFoundException("user '" + login + "' not found!");
      }

      Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
      List<Authority> userAuthorities = authorityService.getUserAuthorities(user);
      for (Authority authority : userAuthorities)
      {
         grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
      }
      org.springframework.security.core.userdetails.User result = new org.springframework.security.core.userdetails.User(
              login,
              user.getPassword(),
              grantedAuthorities);
      return result;
   }

   public void setUserService(IUserService userService)
   {
      this.userService = userService;
   }

   public void setAuthorityService(IAuthorityService authorityService)
   {
      this.authorityService = authorityService;
   }
}
