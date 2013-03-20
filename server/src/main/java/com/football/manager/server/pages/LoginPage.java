package com.football.manager.server.pages;

import com.football.manager.server.cmp.authorization.LoginPanel;
import org.apache.wicket.markup.html.WebPage;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 22.02.13
 * Time: 21:51
 * To change this template use File | Settings | File Templates.
 */
public class LoginPage extends WebPage
{
   public LoginPage()
   {
//      super();
      add(new LoginPanel("loginPanel"));
   }
}
