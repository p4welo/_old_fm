package com.fm.core.cmp.menu;

import org.apache.wicket.markup.html.panel.Panel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 28.03.13
 * Time: 21:17
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractMenuPanel extends Panel
{
   protected MenuPlugin menu;

   public AbstractMenuPanel(String id)
   {
      super(id);
      menu = new MenuPlugin("menu");
      menu.add(provideMenuItems());
      add(menu);
   }

   public List<Class> getTargetClasses()
   {
      return menu.getTargetClasses();
   }

   protected abstract List<MenuItem> provideMenuItems();
}
