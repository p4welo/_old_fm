package com.football.manager.admin;

import com.football.manager.service.IUserEntityService;
import com.football.manager.service.impl.UserEntityServiceImpl;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;
import org.springframework.stereotype.Component;

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
   private String userName;

   //   @SpringBean
   private IUserEntityService userEntityService;

   public AdminSession(Request request)
   {
      super(request);
      userEntityService = AdminApplication.get().getSpringBean(UserEntityServiceImpl.class);
   }

   @Override
   public boolean authenticate(String userName, String password)
   {
      boolean success = userEntityService
              .authenticate(userName, password);//userName.equals("guest") && password.equals("guest");

      if (success)
      {
         this.userName = userName;
      }

      return success;
   }

   @Override
   public Roles getRoles()
   {
      Roles roles = new Roles();

      if (isSignedIn())
      {

         roles.add("ROOT");
      }

      return roles;
   }

   public String getUserName()
   {
      return userName;
   }
}
