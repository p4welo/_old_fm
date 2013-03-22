package com.football.manager.security.service.impl;

import com.football.manager.domain.UserEntity;
import com.football.manager.domain.UserRole;
import com.football.manager.security.service.ISecurityService;
import com.football.manager.service.IUserEntityService;
import com.football.manager.service.IUserRoleService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(SecurityServiceImpl.BEAN_NAME)
public class SecurityServiceImpl implements ISecurityService
{
   public static final String BEAN_NAME = "securityService";

   @Resource
   private IUserEntityService userService;

   @Resource
   private IUserRoleService authorityService;

   @Override
   public UserEntity getLoggedInUser()
   {
      SecurityContext ctx = SecurityContextHolder.getContext();
      Authentication authentication = ctx.getAuthentication();
      if (authentication == null)
      {
         return null;
      }
      User userDetails = (User) authentication.getPrincipal();
      return userService.getByLogin(userDetails.getUsername());
   }

   @Override
   public boolean hasRole(String... roles)
   {
      if (roles != null)
      {
         List<UserRole> authorities = authorityService.getUserRoles(getLoggedInUser());
         for (UserRole authority : authorities)
         {
            for (String role : roles)
            {
               if (authority.getRole().equals(role))
               {
                  return true;
               }
            }
         }
      }
      return false;
   }

}
