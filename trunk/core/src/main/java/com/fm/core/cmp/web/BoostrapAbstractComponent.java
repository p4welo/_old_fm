package com.fm.core.cmp.web;

import com.fm.core.cmp.feedback.CssFeedbackPanel;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.feedback.ComponentFeedbackMessageFilter;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.ResourceModel;

public abstract class BoostrapAbstractComponent extends Panel
{

   private static final long serialVersionUID = -9009523529550959714L;

   private final String id;

   protected String cssClass = "span2";

   public BoostrapAbstractComponent(String id)
   {
      super(id);
      this.id = id;

      Label label = new Label("label", new ResourceModel(id));
      add(label);
   }

   protected abstract void setValidation();

   @Override
   protected void onInitialize()
   {
      super.onInitialize();
      Component component = getField();
      if (component instanceof FormComponent)
      {
         ((FormComponent) component).setLabel(new ResourceModel(id));
         setValidation();
      }
      getField().add(new AttributeModifier("class", cssClass));
      add(new CssFeedbackPanel("feedback", new ComponentFeedbackMessageFilter(getField())));
   }

   public abstract Component getField();

   public String getCssClass()
   {
      return cssClass;
   }

   public void setCssClass(String cssClass)
   {
      this.cssClass = cssClass;
   }
}
