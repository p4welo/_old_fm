package com.fm.core.cmp.button;

import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.util.value.IValueMap;

public abstract class BootstrapLink extends AjaxLink<Void>
{
   private static final long serialVersionUID = 7855197816327649932L;

   public BootstrapLink(String id)
   {
      super(id);
   }

   @Override
   protected void onComponentTag(ComponentTag tag)
   {
      super.onComponentTag(tag);
      IValueMap attributes = tag.getAttributes();
      String clazz = attributes.getString("class");

      if (!isEnabled())
      {
         attributes.put("class", clazz + " disabled");
      }
      else
      {
         attributes.put("class", clazz);
      }
   }
}
