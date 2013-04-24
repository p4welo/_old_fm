package com.fm.core.cmp.notify;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.Application;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.request.cycle.RequestCycle;

/**
 * User: pawel.radomski
 * Date: 24.04.13
 * Time: 11:48
 */
public class Notification
{
   private static final String FIELD_TITLE = "title";

   private static final String FIELD_TYPE = "type";

   private static final String FIELD_CLASS = "addclass";

   private static final String SUCCESS_TYPE = "success";

   private static final String INFO_TYPE = "info";

   private static final String ERROR_TYPE = "error";

   private static final String WARNING_TYPE = "";

   private static final String SUCCESS_TITLE = "success";

   private static final String INFO_TITLE = "info";

   private static final String ERROR_TITLE = "error";

   private static final String WARNING_TITLE = "warning";

   private static void message(String message, String title, String type)
   {
      final StringBuilder javaScript = new StringBuilder();
      javaScript.append("$.pnotify({text: '" + message + "'");

      append(javaScript, FIELD_TITLE, title);
      if (StringUtils.isNotBlank(type))
      {
         append(javaScript, FIELD_TYPE, type);
      }
      append(javaScript, FIELD_CLASS, "stack-bottomright");
      javaScript.append("});");

      AjaxRequestTarget target = RequestCycle.get().find(AjaxRequestTarget.class);
      if (target != null)
      {
         target.appendJavaScript(javaScript.toString());
      }
   }

   private static void append(StringBuilder result, String field, String value)
   {
      result.append(", ");
      result.append(field);
      result.append(": '");
      result.append(value);
      result.append("'");
   }

   public static void success(String message, String title)
   {
      message(message, title, SUCCESS_TYPE);
   }

   public static void success(String message)
   {
      String title = Application.get().getResourceSettings().getLocalizer().getString(SUCCESS_TITLE, null);
      success(message, title);
   }

   public static void error(String message, String title)
   {
      message(message, title, ERROR_TYPE);
   }

   public static void error(String message)
   {
      String title = Application.get().getResourceSettings().getLocalizer().getString(ERROR_TITLE, null);
      error(message, title);
   }

   public static void info(String message, String title)
   {
      message(message, title, INFO_TYPE);
   }

   public static void info(String message)
   {
      String title = Application.get().getResourceSettings().getLocalizer().getString(INFO_TITLE, null);
      info(message, title);
   }

   public static void warn(String message, String title)
   {
      message(message, title, WARNING_TYPE);
   }

   public static void warn(String message)
   {
      String title = Application.get().getResourceSettings().getLocalizer().getString(WARNING_TITLE, null);
      warn(message, title);
   }
}
