package com.fm.server.pages.registerPage.cmp.thread;

import com.fm.domain.User;
import com.fm.service.IUserService;

/**
 * User: pawel.radomski
 * Date: 29.05.13
 * Time: 17:58
 */
public class RegistrationThread implements Runnable
{
   private final User user;

   private String serverEndpoint;

   private final IUserService userService;

   public RegistrationThread(User user, String serverEndpoint, IUserService userService)
   {
      this.user = user;
      this.serverEndpoint = serverEndpoint;
      this.userService = userService;
   }

   @Override
   public void run()
   {
      userService.registerUser(user, serverEndpoint);
   }
}
