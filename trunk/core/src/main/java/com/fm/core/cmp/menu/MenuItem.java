package com.fm.core.cmp.menu;

import java.io.Serializable;

/**
 * User: pawel
 * Date: 26.01.13
 * Time: 10:49
 */
public class MenuItem implements Serializable
{
   private String resourceKey;

   private String iconKey;

   private Class target;

   public MenuItem(String resourceKey, String iconKey, Class target)
   {
      this.resourceKey = resourceKey;
      this.iconKey = iconKey;
      this.target = target;
   }

   public String getResourceKey()
   {
      return resourceKey;
   }

   public void setResourceKey(String resourceKey)
   {
      this.resourceKey = resourceKey;
   }

   public Class getTarget()
   {
      return target;
   }

   public void setTarget(Class target)
   {
      this.target = target;
   }

   public String getIconKey()
   {
      return iconKey;
   }

   public void setIconKey(String iconKey)
   {
      this.iconKey = iconKey;
   }
}
