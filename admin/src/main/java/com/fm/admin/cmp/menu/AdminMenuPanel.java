package com.fm.admin.cmp.menu;

import com.fm.admin.pages.GameConfigPage;
import com.fm.admin.pages.Index;
import com.fm.admin.pages.LeagueListPage;
import com.fm.core.cmp.menu.MenuPlugin;
import com.fm.domain.FmIconTypes;
import org.apache.wicket.markup.html.panel.Panel;

import java.util.List;

//import com.fm.admin.AdminApplication;

/**
 * User: pawel
 * Date: 26.01.13
 * Time: 10:53
 */
public class AdminMenuPanel extends Panel implements AdminMenuKeys
{
   private MenuPlugin menu;

   public AdminMenuPanel(String id)
   {
      super(id);
      menu = new MenuPlugin("menu");
      menu.add(MENU_ADMIN_LEAGUE_LIST_PAGE, FmIconTypes.LIST, LeagueListPage.class);
      menu.add(MENU_ADMIN_USERS_PAGE, FmIconTypes.USER, Index.class);
      menu.add(MENU_ADMIN_RULES_PAGE, FmIconTypes.WRENCH, GameConfigPage.class);
      add(menu);
   }

   public List<Class> getTargetClasses()
   {
      return menu.getTargetClasses();
   }
}
