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

   private String confirmPassword;

   public RegisterPage()
   {
      initView();
   }

   private void initView()
   {
      Form form = new Form("registerForm");
      form.setOutputMarkupId(true);
      form.add(new CssFeedbackPanel("feedback"));
      form.add(new BootstrapTextFieldPanel("login",
              new PropertyModel(this, "manager." + Manager.FIELD_USER + "." + User.FIELD_LOGIN), "span4"));
      form.add(new BootstrapPasswordFieldPanel("password",
              new PropertyModel(this, "manager." + Manager.FIELD_USER + "." + User.FIELD_PASSWORD), "span4"));
      form.add(new BootstrapPasswordFieldPanel("confirmPassword", new PropertyModel(this, "confirmPassword"), "span4"));
      form.add(new BootstrapTextFieldPanel("email",
              new PropertyModel(this, "manager." + Manager.FIELD_USER + "." + User.FIELD_EMAIL), "span4"));

      form.add(new BootstrapTextFieldPanel("name", new PropertyModel(this, "manager." + Manager.FIELD_NAME), "span4"));
      form.add(new BootstrapTextFieldPanel("surname", new PropertyModel(this, "manager." + Manager.FIELD_SURNAME),
              "span4"));

      form.add(new BootstrapTextFieldPanel("team",
              new PropertyModel(this, "manager." + Manager.FIELD_TEAM + "." + Team.FIELD_NAME), "span4"));

      form.add(new AjaxSubmitLink("submit")
      {
         @Override
         protected void onSubmit(AjaxRequestTarget target, Form<?> form)
         {
            if (!StringUtils.equals(manager.getUser().getPassword(), confirmPassword))
            {
               error(getString("password.does.not.match"));
            }
            else
            {
               managerService.save(manager);
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
