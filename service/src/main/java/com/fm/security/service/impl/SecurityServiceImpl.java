package com.fm.security.service.impl;

import com.fm.domain.Authority;
import com.fm.domain.User;
import com.fm.security.service.ISecurityService;
import com.fm.service.IAuthorityService;
import com.fm.service.IUserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(SecurityServiceImpl.BEAN_NAME)
public class SecurityServiceImpl implements ISecurityService
{
   public static final String BEAN_NAME = "securityService";

   @Resource
   private IUserService userService;

   @Resource
   private IAuthorityService authorityService;

   @Override
   public User getLoggedInUser()
   {
      SecurityContext ctx = SecurityContextHolder.getContext();
      Authentication authentication = ctx.getAuthentication();
      if (authentication == null)
      {
         return null;
      }
      org.springframework.security.core.userdetails.User userDetails = (org.springframework.security.core.userdetails.User) authentication
              .getPrincipal();
      return userService.getByLogin(userDetails.getUsername());
   }

   @Override
   public boolean hasRole(String... roles)
   {
      if (roles != null)
      {
         List<Authority> authorities = authorityService.getUserAuthorities(getLoggedInUser());
         for (Authority authority : authorities)
         {
            for (String role : roles)
            {
               if (authority.equals(role))
               {
                  return true;
               }
            }
         }
      }
      return false;
   }
}
