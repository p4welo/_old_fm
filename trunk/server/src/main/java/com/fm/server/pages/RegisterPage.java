package com.fm.server.pages;

import com.fm.core.cmp.feedback.CssFeedbackPanel;
import com.fm.core.cmp.web.BootstrapPasswordFieldPanel;
import com.fm.core.cmp.web.BootstrapTextFieldPanel;
import com.fm.domain.Manager;
import com.fm.domain.Team;
import com.fm.domain.User;
import com.fm.server.api.ServerApiMapping;
import com.fm.service.IManagerService;
import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
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
   private IManagerService managerService;

   private Manager manager;

   private String confirmedPassword;

   public RegisterPage()
   {
      initView();
   }

   private void initView()
   {
      Form form = new Form("registerForm");
      form.setOutputMarkupId(true);
      form.add(new CssFeedbackPanel("feedback"));

      BootstrapTextFieldPanel login = new BootstrapTextFieldPanel("login",
              new PropertyModel(this, "manager." + Manager.FIELD_USER + "." + User.FIELD_LOGIN), "span4");
      login.setValidation();
      form.add(login);

      BootstrapPasswordFieldPanel password = new BootstrapPasswordFieldPanel("password",
              new PropertyModel(this, "manager." + Manager.FIELD_USER + "." + User.FIELD_PASSWORD), "span4");
      password.setValidation();
      form.add(password);

      BootstrapPasswordFieldPanel confirmPassword = new BootstrapPasswordFieldPanel("confirmPassword",
              new PropertyModel(this, "confirmedPassword"), "span4");
      confirmPassword.setValidation();
      form.add(confirmPassword);

      BootstrapTextFieldPanel email = new BootstrapTextFieldPanel("email",
              new PropertyModel(this, "manager." + Manager.FIELD_USER + "." + User.FIELD_EMAIL), "span4");
      email.setValidation();
      form.add(email);

      BootstrapTextFieldPanel name = new BootstrapTextFieldPanel("name",
              new PropertyModel(this, "manager." + Manager.FIELD_NAME), "span4");
      name.setValidation();
      form.add(name);

      BootstrapTextFieldPanel surname = new BootstrapTextFieldPanel("surname",
              new PropertyModel(this, "manager." + Manager.FIELD_SURNAME),
              "span4");
      surname.setValidation();
      form.add(surname);

      BootstrapTextFieldPanel team = new BootstrapTextFieldPanel("team",
              new PropertyModel(this, "manager." + Manager.FIELD_TEAM + "." + Team.FIELD_NAME), "span4");
      team.setValidation();
      form.add(team);

      form.add(new AjaxSubmitLink("submit")
      {
         @Override
         protected void onSubmit(AjaxRequestTarget target, Form<?> form)
         {
            if (!StringUtils.equals(manager.getUser().getPassword(), confirmedPassword))
            {
               error(getString("password.does.not.match"));
            }
            else
            {
               managerService.createNewManager(manager);
               success(getString("registration.success"));
            }

            target.add(form);
         }

         @Override
         protected void onError(AjaxRequestTarget target, Form<?> form)
         {
            target.add(form);
         }
      });
      add(form);
   }
}