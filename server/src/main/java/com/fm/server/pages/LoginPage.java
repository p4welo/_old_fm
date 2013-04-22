package com.fm.server.pages;

import com.fm.server.api.ServerApiMapping;
import com.fm.server.cmp.authorization.LoginForm;
import org.apache.wicket.markup.html.WebPage;
import org.wicketstuff.annotation.mount.MountPath;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 22.02.13
 * Time: 21:51
 * To change this template use File | Settings | File Templates.
 */
@MountPath(ServerApiMapping.LOGIN_PAGE)
public class LoginPage extends WebPage
{
   public LoginPage()
   {
//      super();
//      add(new LoginPanel("loginPanel"));
      add(new LoginForm("signInForm"));
   }
}
