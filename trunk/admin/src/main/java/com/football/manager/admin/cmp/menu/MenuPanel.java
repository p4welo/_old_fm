package com.football.manager.admin.cmp.menu;

import com.football.manager.admin.pages.Index;
import com.football.manager.admin.pages.LeagueListPage;
import org.apache.wicket.markup.html.panel.Panel;

import java.util.List;

/**
 * User: pawel
 * Date: 26.01.13
 * Time: 10:53
 */
public class MenuPanel extends Panel implements MenuKeys
{
   private MenuPlugin menu;

   public MenuPanel(String id)
   {
      super(id);
      menu = new MenuPlugin("menu");
      menu.add(MENU_ADMIN_LEAGUE_LIST_PAGE, LeagueListPage.class);
      menu.add(MENU_ADMIN_RULES_PAGE, Index.class);
      add(menu);
   }

   public List<Class> getTargetClasses()
   {
      return menu.getTargetClasses();
   }
}
