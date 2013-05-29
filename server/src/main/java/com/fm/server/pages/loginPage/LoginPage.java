package com.fm.server.pages.loginPage;

import com.fm.server.api.ServerApiMapping;
import com.fm.server.pages.loginPage.cmp.authorization.LoginForm;
import com.fm.server.pages.registerPage.RegisterPage;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
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
      LoginForm form = new LoginForm("signInForm");
      add(form);
      form.add(new AjaxLink<Void>("register")
      {
         @Override
         public void onClick(AjaxRequestTarget target)
         {
            setResponsePage(RegisterPage.class);
         }
      });
   }
}
