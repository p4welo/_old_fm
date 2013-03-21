package com.football.manager.admin.pages;

import com.football.manager.admin.api.AdminApiMappings;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.wicketstuff.annotation.mount.MountPath;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 21.03.13
 * Time: 23:09
 * To change this template use File | Settings | File Templates.
 */
@MountPath(AdminApiMappings.GAME_CONFIG_PAGE)
@AuthorizeInstantiation("ROLE_ADMIN")
public class GameConfigPage extends AbstractPage
{
   public GameConfigPage()
   {
      super();
   }
}
