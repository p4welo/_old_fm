package com.fm.security.service.impl;

import com.fm.domain.Authority;
import com.fm.domain.UserEntity;
import com.fm.service.IAuthorityService;
import com.fm.service.IUserEntityService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
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
   private IUserEntityService userService;

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
      UserEntity user = userService.getByLogin(login);
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
      User result = new User(
              login,
              user.getPassword(),
              grantedAuthorities);
      return result;
   }

   public void setUserService(IUserEntityService userService)
   {
      this.userService = userService;
   }

   public void setAuthorityService(IAuthorityService authorityService)
   {
      this.authorityService = authorityService;
   }
}
