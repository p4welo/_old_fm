package com.fm.admin.cmp.menu;

import com.fm.admin.pages.ManagerListPage;
import com.fm.admin.pages.configPage.ConfigPage;
import com.fm.admin.pages.leagueListPage.LeagueListPage;
import com.fm.core.cmp.menu.AbstractMenuPanel;
import com.fm.core.cmp.menu.MenuItem;
import com.fm.domain.defined.FmIconTypes;

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
              new MenuItem(LEAGUE_LIST_PAGE, FmIconTypes.LIST, LeagueListPage.class),
              new MenuItem(USERS_PAGE, FmIconTypes.GROUP, ManagerListPage.class),
              new MenuItem(CONFIG_PAGE, FmIconTypes.CONFIG, ConfigPage.class)
      );
   }
}
