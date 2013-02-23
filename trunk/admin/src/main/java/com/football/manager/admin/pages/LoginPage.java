package com.football.manager.admin.pages;

import org.apache.wicket.authroles.authentication.panel.SignInPanel;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 22.02.13
 * Time: 21:51
 * To change this template use File | Settings | File Templates.
 */
public class LoginPage extends AbstractPage
{
   public LoginPage()
   {
      super();
      add(new SignInPanel("signInPanel"));
   }
}
