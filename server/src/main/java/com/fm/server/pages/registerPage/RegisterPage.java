package com.fm.server.pages.registerPage;

import com.fm.core.cmp.web.BootstrapPasswordFieldPanel;
import com.fm.core.cmp.web.BootstrapTextFieldPanel;
import com.fm.domain.User;
import com.fm.server.api.ServerApiMapping;
import com.fm.server.pages.loginPage.LoginPage;
import com.fm.server.pages.registerPage.cmp.thread.RegistrationThread;
import com.fm.server.pages.registerPage.cmp.validator.LoginUniqueValidator;
import com.fm.service.IUserService;
import com.fm.user.TestPage;
import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

/**
 * User: pawel.radomski
 * Date: 22.04.13
 * Time: 16:19
 */
@MountPath(ServerApiMapping.REGISTER_PAGE)
public class RegisterPage extends WebPage
{
   @SpringBean
   private IUserService userService;

   private User user;

   private String confirmedPassword;

   private Boolean success = false;

   public RegisterPage()
   {
   }

   @Override
   protected void onInitialize()
   {
      super.onInitialize();
      final WebMarkupContainer confirmPanel = new WebMarkupContainer("confirmPanel")
      {
         @Override
         protected void onConfigure()
         {
            super.onConfigure();
            setVisible(success);
         }
      };
      confirmPanel.setOutputMarkupPlaceholderTag(true);
      confirmPanel.add(new Link<Void>("returnLink")
      {
         @Override
         public void onClick()
         {
            setResponsePage(LoginPage.class);
         }
      });
      add(confirmPanel);
      final WebMarkupContainer registerPanel = new WebMarkupContainer("registerPanel")
      {
         @Override
         protected void onConfigure()
         {
            super.onConfigure();
            setVisible(!success);
         }
      };
      registerPanel.setOutputMarkupPlaceholderTag(true);
      Form form = new Form("registerForm");
      form.setOutputMarkupId(true);

      BootstrapTextFieldPanel login = new BootstrapTextFieldPanel("login",
              new PropertyModel(this, "user." + User.FIELD_LOGIN), "span4");
      login.setValidation();
      login.addValidator(new LoginUniqueValidator());
      form.add(login);

      BootstrapPasswordFieldPanel password = new BootstrapPasswordFieldPanel("password",
              new PropertyModel(this, "user." + User.FIELD_PASSWORD), "span4");
      password.setValidation();
      form.add(password);

      BootstrapPasswordFieldPanel confirmPassword = new BootstrapPasswordFieldPanel("confirmPassword",
              new PropertyModel(this, "confirmedPassword"), "span4");
      confirmPassword.setValidation();
      form.add(confirmPassword);

      BootstrapTextFieldPanel email = new BootstrapTextFieldPanel("email",
              new PropertyModel(this, "user." + User.FIELD_EMAIL), "span4");
      email.setValidation();
      form.add(email);

      BootstrapTextFieldPanel name = new BootstrapTextFieldPanel("name",
              new PropertyModel(this, "user." + User.FIELD_MANAGER_NAME), "span4");
      name.setValidation();
      form.add(name);

      final BootstrapTextFieldPanel surname = new BootstrapTextFieldPanel("surname",
              new PropertyModel(this, "user." + User.FIELD_MANAGER_SURNAME),
              "span4");
      surname.setValidation();
      form.add(surname);

      BootstrapTextFieldPanel team = new BootstrapTextFieldPanel("team",
              new PropertyModel(this, "user." + User.FIELD_TEAM_NAME), "span4");
      team.setValidation();
      form.add(team);

      form.add(new AjaxSubmitLink("submit")
      {
         @Override
         protected void onSubmit(AjaxRequestTarget target, Form<?> form)
         {
            if (!StringUtils.equals(user.getPassword(), confirmedPassword))
            {
               error(getString("password.does.not.match"));
            }
            else
            {
               Thread registration = new Thread(new RegistrationThread(user, userService));
               registration.start();
               success = true;
            }

            target.add(registerPanel);
            target.add(confirmPanel);
         }

         @Override
         protected void onError(AjaxRequestTarget target, Form<?> form)
         {
            target.add(form);
         }
      });
      form.add(new Link<Void>("return")
      {
         @Override
         public void onClick()
         {
            setResponsePage(TestPage.class);
//            setResponsePage(LoginPage.class);
         }
      });
      registerPanel.add(form);
      add(registerPanel);
   }
}
