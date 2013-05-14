package com.fm.core.ajax;

import org.apache.wicket.ajax.attributes.AjaxCallListener;

/**
 * User: pawel.radomski
 * Date: 14.05.13
 * Time: 14:24
 */
public class ConfirmationCallListener extends AjaxCallListener
{
   private static final long serialVersionUID = 6800889134407321820L;

   public ConfirmationCallListener(String msg, Object... params)
   {
      super();
      onPrecondition("return confirm('" + getMessage(msg, params) + "');");
   }

   protected String getMessage(String msg, Object... params)
   {
      if (params == null || params.length == 0)
      {
         return msg;
      }

      Object[] formatted = new Object[params.length];
      int i = 0;
      for (Object object : params)
      {
         if (object instanceof String)
         {
            formatted[i] = object;
         }
         else
         {
            formatted[i] = object.toString();
         }
         i++;
      }
      return format(msg, formatted);
   }

   protected String format(String msg, final Object... params)
   {
      msg = msg.replaceAll("\\{\\}", "%s");
      return String.format(msg, params);
   }
}