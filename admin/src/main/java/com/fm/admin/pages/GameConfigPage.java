package com.fm.admin.pages;

import com.fm.admin.api.AdminApiMappings;
import com.fm.admin.cmp.breadcrumb.LeagueListBreadcrumb;
import com.fm.core.cmp.breadcrumb.BootstrapBreadcrumbPanel;
import com.fm.service.IPositionService;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
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
public class GameConfigPage extends AdminAbstractPage
{
   @SpringBean
   private IPositionService positionService;

   private long positionCount;

   public GameConfigPage()
   {
      super();
      positionCount = positionService.getCount();
      add(new Label("positionsCount", new PropertyModel(this, "positionCount")));
   }

   public long getPositionCount()
   {
      return positionCount;
   }

   public void setPositionCount(long positionCount)
   {
      this.positionCount = positionCount;
   }

   @Override
   protected BootstrapBreadcrumbPanel provideBreadcrumb(String id)
   {
      return new LeagueListBreadcrumb(id);
   }
}
