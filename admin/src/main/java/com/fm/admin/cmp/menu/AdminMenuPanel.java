package com.fm.admin.cmp.menu;

import com.fm.admin.pages.GameConfigPage;
import com.fm.admin.pages.Index;
import com.fm.admin.pages.LeagueListPage;
import com.fm.core.cmp.menu.AbstractMenuPanel;
import com.fm.core.cmp.menu.MenuItem;
import com.fm.domain.FmIconTypes;

import java.util.Arrays;
import java.util.List;

//importer com.fm.admin.AdminApplication;

/**
 * User: pawel
 * Date: 26.01.13
 * Time: 10:53
 */
public class AdminMenuPanel extends AbstractMenuPanel implements AdminMenuKeys
{
   public AdminMenuPanel(String id)
   {
      super(id);
   }

   @Override
   protected List<MenuItem> provideMenuItems()
   {
      return Arrays.asList(
              new MenuItem(MENU_ADMIN_LEAGUE_LIST_PAGE, FmIconTypes.LIST, LeagueListPage.class),
              new MenuItem(MENU_ADMIN_USERS_PAGE, FmIconTypes.GROUP, Index.class),
              new MenuItem(MENU_ADMIN_CONFIG_PAGE, FmIconTypes.CONFIG, GameConfigPage.class)
      );
   }
}
