package com.fm.core.cmp.newTable;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxChannel;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.attributes.ThrottlingSettings;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.markup.html.form.AbstractTextComponent;
import org.apache.wicket.util.time.Duration;

import java.io.Serializable;

public abstract class FilterDecorator implements Serializable
{
   private static final long serialVersionUID = 2426839135610711760L;

   public void decorate(final Component filter, String placeholder)
   {
      filter.add(new OnChangeAjaxBehavior()
      {
         private static final long serialVersionUID = 6135695488072955677L;

         @Override
         protected void onUpdate(AjaxRequestTarget target)
         {
            FilterDecorator.this.onUpdate(target);
         }

         @Override
         protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
         {
            super.updateAjaxAttributes(attributes);
            Duration duration;
            if (filter instanceof AbstractTextComponent)
            {
               duration = Duration.ONE_SECOND;
            }
            else
            {
               duration = Duration.NONE;
            }
            attributes.setThrottlingSettings(new ThrottlingSettings(filter.getId(), duration, true));
            attributes.setChannel(new AjaxChannel(filter.getId(), AjaxChannel.Type.DROP));
         }
      });

      if (!StringUtils.isBlank(placeholder))
      {
         filter.add(new AttributeModifier("placeholder", placeholder));
      }
   }

   protected abstract void onUpdate(AjaxRequestTarget target);
}
