package com.football.manager.server.cmp.authorization;

import com.football.manager.admin.cmp.feedback.CssFeedbackPanel;
import com.football.manager.admin.pages.LeagueListPage;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.feedback.ComponentFeedbackMessageFilter;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.model.CompoundPropertyModel;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 21.03.13
 * Time: 20:57
 * To change this template use File | Settings | File Templates.
 */
public class LoginForm extends Form
{
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
         setResponsePage(LeagueListPage.class);
//         if (((AdminSession) Session.get()).getUser()
//         setDefaultResponsePageIfNecessary();
      }
      else
      {
         error(getString("login.failed"));
      }
   }
}
