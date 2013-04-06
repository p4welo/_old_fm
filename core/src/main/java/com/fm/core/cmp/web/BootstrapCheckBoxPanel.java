package com.fm.core.cmp.web;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.model.IModel;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 06.04.13
 * Time: 12:18
 * To change this template use File | Settings | File Templates.
 */
public class BootstrapCheckBoxPanel extends BoostrapAbstractComponent
{
   private CheckBox checkBox;

   public BootstrapCheckBoxPanel(String id, IModel<Boolean> model, String cssClazz)
   {
      super(id);
      this.cssClass = cssClazz;
      checkBox = new CheckBox("checkbox", model);
      add(checkBox);
   }

   public BootstrapCheckBoxPanel(String id, IModel<Boolean> model)
   {
      this(id, model, "");
   }

   @Override
   protected void setValidation()
   {
   }

   @Override
   public Component getField()
   {
      return checkBox;
   }
}
