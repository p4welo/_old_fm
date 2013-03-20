package com.football.manager.server.cmp.menu;

import com.football.manager.domain.UserEntity;
import com.football.manager.server.AdminApplication;
import com.football.manager.server.pages.Index;
import com.football.manager.server.pages.LeagueListPage;
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

   private UserEntity entity;

   public MenuPanel(String id)
   {
      super(id);
      menu = new MenuPlugin("menu");
      menu.add(MENU_ADMIN_LEAGUE_LIST_PAGE, LeagueListPage.class);
      menu.add(MENU_ADMIN_USERS_PAGE, Index.class);
      menu.add(MENU_ADMIN_RULES_PAGE, Index.class);
      add(menu);
      entity = ((AdminApplication) getApplication()).getSession().getUser();
//      add(new Label("user", new PropertyModel(this, "entity.login")));
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
