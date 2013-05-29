package com.fm.server.pages.loginPage.cmp.authorization;

import com.fm.admin.pages.leagueListPage.LeagueListPage;
import com.fm.core.cmp.authorization.UserAuthorities;
import com.fm.core.cmp.feedback.CssFeedbackPanel;
import com.fm.security.service.ISecurityService;
import com.fm.user.TestPage;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.feedback.ComponentFeedbackMessageFilter;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 21.03.13
 * Time: 20:57
 * To change this template use File | Settings | File Templates.
 */
public class LoginForm extends Form
{
   @SpringBean
   private ISecurityService securityService;

   private String username;

   private String password;

   public LoginForm(String id)
   {
      super(id);
      setModel(new CompoundPropertyModel(this));
      add(new CssFeedbackPanel("feedback", new ComponentFeedbackMessageFilter(this)));
      RequiredTextField username = new RequiredTextField("username");
      PasswordTextField password = new PasswordTextField("password");

      add(new CssFeedbackPanel("usernameFeedback", new ComponentFeedbackMessageFilter(username)));
      add(new CssFeedbackPanel("passwordFeedback", new ComponentFeedbackMessageFilter(password)));

      add(username);
      add(password);
   }

   @Override
   protected void onSubmit()
   {
      AuthenticatedWebSession session = AuthenticatedWebSession.get();
      if (session.signIn(username, password))
      {
         if (securityService.hasRole(UserAuthorities.ADMIN))
         {
            setResponsePage(LeagueListPage.class);
         }
         else if (securityService.hasRole(UserAuthorities.USER))
         {
            setResponsePage(TestPage.class);
         }

      }
      else
      {
         error(getString("login.failed"));
      }
   }
}
