package com.fm.core.cmp.newTable.field;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.IOnChangeListener;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class ButtonTrueFalse extends FormComponent<Boolean> implements IOnChangeListener
{
   private static final long serialVersionUID = -1935792210156340257L;

   private boolean pressed;

   private String buttonCss = "btn btn-info";

   public ButtonTrueFalse(String id, IModel<Boolean> model)
   {
      super(id, model);

      setType(Boolean.class);
      setOutputMarkupId(true);
   }

   @Override
   public void onSelectionChanged()
   {
      setDefaultModelObject(pressed = !pressed);
      setConvertedInput(pressed);
      if (pressed)
      {
         onPressed();
      }
      else
      {
         onUnpressed();
      }
      updateModel();
   }

   @Override
   protected void onComponentTag(ComponentTag tag)
   {

      CharSequence url = urlFor(IOnChangeListener.INTERFACE, new PageParameters());
      tag.put("onclick", "window.location.href='" + url +
              (url.toString().indexOf('?') > -1 ? "&" : "?") + getInputName() +
              "=' + this.checked;");

      super.onComponentTag(tag);
   }

   public void onPressed()
   {
      this.add(new AttributeAppender("class", " disabled"));
   }

   public void onUnpressed()
   {
      resetButton();
   }

   public void resetButton()
   {
      this.add(new AttributeModifier("class", buttonCss));
      setPressed(false);
      getParent().addOrReplace(this);
      setDefaultModelObject(pressed);

   }

   public void setButtonCss(String buttonCss)
   {
      this.buttonCss = buttonCss;
   }

   public void setTooltip(String message)
   {
      add(new AttributeModifier("data-toggle", "tooltip"));
      add(new AttributeModifier("title", message));
   }

   public void setPressed(boolean pressed)
   {
      this.pressed = pressed;
   }

   @Override
   protected void onBeforeRender()
   {
      if (pressed)
      {
         this.add(new AttributeAppender("class", " disabled"));
      }
      super.onBeforeRender();
   }
}

