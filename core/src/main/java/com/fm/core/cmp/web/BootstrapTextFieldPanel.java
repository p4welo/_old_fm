package com.fm.core.cmp.web;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.validation.IValidator;

/**
 * Small Panel for TextField with integrated feedback & validation
 */

public class BootstrapTextFieldPanel<T> extends BoostrapAbstractComponent
{
   private static final long serialVersionUID = -7343831494116669887L;

   TextField<T> textField;

   public BootstrapTextFieldPanel(String id, IModel<T> model)
   {
      super(id);
      textField = new TextField<T>("textField", model);
      add(textField);
   }

   public BootstrapTextFieldPanel(String id, IModel<T> model, String cssClazz)
   {
      this(id, model);
      this.cssClass = cssClazz;

   }

   public void setValidation()
   {
      textField.setRequired(true);
   }

   public void addValidator(IValidator validator)
   {
      textField.add(validator);
   }

   public void setInputType(String type)
   {
      textField.add(new AttributeModifier("type", type));
   }

   @Override
   public FormComponent getField()
   {
      return textField;
   }
}
