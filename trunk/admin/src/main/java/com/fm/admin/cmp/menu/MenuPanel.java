package com.fm.admin.cmp.menu;

import com.fm.admin.cmp.authorization.LogoutLink;
import com.fm.admin.pages.GameConfigPage;
import com.fm.admin.pages.Index;
import com.fm.admin.pages.LeagueListPage;
import com.fm.domain.UserEntity;
import org.apache.wicket.markup.html.panel.Panel;

import java.util.List;

//import com.fm.admin.AdminApplication;

/**
 * User: pawel
 * Date: 26.01.13
 * Time: 10:53
 */
public class MenuPanel extends Panel implements MenuKeys
{
   private MenuPlugin menu;

   private UserEntity entity;

   public MenuPanel(String id)
   {
      super(id);
      menu = new MenuPlugin("menu");
      menu.add(MENU_ADMIN_LEAGUE_LIST_PAGE, LeagueListPage.class);
      menu.add(MENU_ADMIN_USERS_PAGE, Index.class);
      menu.add(MENU_ADMIN_RULES_PAGE, GameConfigPage.class);
      add(menu);
      add(new LogoutLink("logout", LeagueListPage.class));
   }

   public List<Class> getTargetClasses()
   {
      return menu.getTargetClasses();
   }

   public UserEntity getEntity()
   {
      return entity;
   }

   public void setEntity(UserEntity entity)
   {
      this.entity = entity;
   }
}
