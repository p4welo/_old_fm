package com.football.manager.server;

import com.football.manager.domain.UserEntity;
import com.football.manager.service.IUserEntityService;
import com.football.manager.service.IUserRoleService;
import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;
import org.apache.wicket.spring.injection.annot.SpringBean;
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
   private UserEntity user;

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
      boolean success = userEntityService.authenticate(userName, password);
      if (success)
      {
         this.user = userEntityService.findByLogin(userName);
      }
      return success;
   }

   @Override
   public Roles getRoles()
   {
      Roles roles = new Roles();
      if (isSignedIn() && user != null)
      {
         List<String> list = userRoleService.getRoles(user);
         if (list != null)
         {
            for (String role : list)
            {
               roles.add(role);
            }
         }
      }
      return roles;
   }

   public UserEntity getUser()
   {
      return user;
   }

   public static AdminSession get()
   {
      return (AdminSession) Session.get();
   }
}
