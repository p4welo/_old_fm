package com.fm.core.cmp.feedback;

import org.apache.commons.lang3.StringUtils;

/**
 * User: pawel.radomski
 * Date: 02.04.13
 * Time: 14:36
 */
public class NotifyOptions
{
   public static final String FIELD_TITLE = "title";

   public static final String FIELD_TYPE = "type";

   public static final String FIELD_CLASS = "addclass";

   public static final String FIELD_ANIMATION = "animation";

   private String cssClass = "stack-bottomright";

   private String title;

   private String type;

   private String jqueryAnimation;

   public NotifyOptions()
   {
   }

   public NotifyOptions(String type)
   {
      this.type = type;
   }

   public NotifyOptions(String type, String title)
   {
      this.title = title;
      this.type = type;
   }

   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();
      if (StringUtils.isNotBlank(title))
      {
         append(result, FIELD_TITLE, title);
      }
      if (StringUtils.isNotBlank(type))
      {
         append(result, FIELD_TYPE, type);
      }
      if (StringUtils.isNotBlank(cssClass))
      {
         append(result, FIELD_CLASS, cssClass);
      }
      if (StringUtils.isNotBlank(jqueryAnimation))
      {
         append(result, FIELD_ANIMATION, jqueryAnimation);
      }
      return result.toString();
   }

   private void append(StringBuilder result, String field, String value)
   {
      if (result.length() > 0)
      {
         result.append(", ");
      }
      result.append(field);
      result.append(": '");
      result.append(value);
      result.append("'");
   }

   public String getTitle()
   {
      return title;
   }

   public void setTitle(String title)
   {
      this.title = title;
   }

   public String getCssClass()
   {
      return cssClass;
   }

   public void setCssClass(String cssClass)
   {
      this.cssClass = cssClass;
   }

   public String getType()
   {
      return type;
   }

   public void setType(String type)
   {
      this.type = type;
   }

   public String getJqueryAnimation()
   {
      return jqueryAnimation;
   }

   public void setJqueryAnimation(String jqueryAnimation)
   {
      this.jqueryAnimation = jqueryAnimation;
   }
}
