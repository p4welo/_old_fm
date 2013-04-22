package com.fm.core.cmp.web;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.model.IModel;

/**
 * User: pawel.radomski
 * Date: 22.04.13
 * Time: 15:20
 */
public class BootstrapPasswordFieldPanel<T> extends BoostrapAbstractComponent
{
   private PasswordTextField passwordTextField;

   public BootstrapPasswordFieldPanel(String id, IModel<String> model)
   {
      super(id);
      passwordTextField = new PasswordTextField("passwordField", model);
      add(passwordTextField);
   }

   public BootstrapPasswordFieldPanel(String id, IModel<String> model, String cssClazz)
   {
      this(id, model);
      this.cssClass = cssClazz;
   }

   @Override
   public void setValidation()
   {
      passwordTextField.setRequired(true);
   }

   @Override
   public Component getField()
   {
      return passwordTextField;
   }
}
