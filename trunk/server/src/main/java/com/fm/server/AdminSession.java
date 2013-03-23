package com.fm.server;

import com.fm.domain.UserEntity;
import com.fm.security.service.ISecurityService;
import com.fm.service.IUserEntityService;
import com.fm.service.IUserRoleService;
import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 22.02.13
 * Time: 21:54
 * To change this template use File | Settings | File Templates.
 */
@Component
public class AdminSession extends AuthenticatedWebSession
{
   @SpringBean(name = "authenticationManager")
   private AuthenticationManager authenticationManager;

   @SpringBean
   private ISecurityService securityService;

   @SpringBean
   private IUserEntityService userEntityService;

   @SpringBean
   private IUserRoleService userRoleService;

   public AdminSession(Request request)
   {
      super(request);
      Injector.get().inject(this);
   }

   @Override
   public boolean authenticate(String userName, String password)
   {
//      boolean success = userEntityService.authenticate(userName, password);
//      if (success)
//      {
//         this.user = userEntityService.getByLogin(userName);
//      }
//      return success;
      boolean authenticated = false;
      try
      {
         Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                 userName,
                 password));
         SecurityContextHolder.getContext().setAuthentication(authentication);
         authenticated = authentication.isAuthenticated();
      }
      catch (AuthenticationException e)
      {
         authenticated = false;
      }
      return authenticated;
   }

   //   @Override
//   public Roles getRoles()
//   {
//      Roles roles = new Roles();
//      if (isSignedIn() && user != null)
//      {
//         List<String> list = userRoleService.getRoles(user);
//         if (list != null)
//         {
//            for (String role : list)
//            {
//               roles.add(role);
//            }
//         }
//      }
//      return roles;
//   }
//
//   public UserEntity getUser()
//   {
//      return user;
//   }
//
   public static AdminSession get()
   {
      return (AdminSession) Session.get();
   }

   @Override
   public Roles getRoles()
   {
      Roles roles = new Roles();
      getRolesIfSignedIn(roles);
      return roles;
   }

   @Override
   public void invalidate()
   {
      super.invalidate();
      SecurityContextHolder.getContext().setAuthentication(null);
   }

   private void getRolesIfSignedIn(Roles roles)
   {
      if (isSignedIn())
      {
         addRolesFromAuthentication(roles);
      }
   }

   private void addRolesFromAuthentication(Roles roles)
   {
      UserEntity loggedInUser = securityService.getLoggedInUser();
      if (isSignedIn() && loggedInUser != null)
      {
         List<String> list = userRoleService.getRoles(loggedInUser);
         if (list != null)
         {
            for (String role : list)
            {
               roles.add(role);
            }
         }
      }
   }
}
