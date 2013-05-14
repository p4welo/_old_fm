package com.fm.admin.pages.configPage;

import com.fm.admin.api.AdminApiMappings;
import com.fm.admin.cmp.breadcrumb.ConfigBreadcrumb;
import com.fm.admin.pages.AdminAbstractPage;
import com.fm.admin.pages.configPage.cmp.tabbedPanel.NameTab;
import com.fm.admin.pages.configPage.cmp.tabbedPanel.ParameterTab;
import com.fm.admin.pages.configPage.cmp.tabbedPanel.PositionTab;
import com.fm.admin.pages.configPage.cmp.tabbedPanel.SurnameTab;
import com.fm.core.cmp.authorization.UserAuthorities;
import com.fm.core.cmp.breadcrumb.BootstrapBreadcrumbPanel;
import com.fm.core.cmp.tabbedPanel.BootstrapTabbedPanel;
import com.fm.service.IPositionService;
import org.apache.wicket.Component;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.extensions.ajax.markup.html.AjaxLazyLoadPanel;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 21.03.13
 * Time: 23:09
 * To change this template use File | Settings | File Templates.
 */
@MountPath(AdminApiMappings.GAME_CONFIG_PAGE)
@AuthorizeInstantiation(UserAuthorities.ADMIN)
public class ConfigPage extends AdminAbstractPage
{
   @SpringBean
   private IPositionService positionService;

   public ConfigPage()
   {
      super();
      List<ITab> tabs = new ArrayList<ITab>();
      tabs.add(new AbstractTab(new ResourceModel("position.tab"))
      {
         @Override
         public WebMarkupContainer getPanel(String panelId)
         {
            return new AjaxLazyLoadPanel(panelId)
            {
               @Override
               public Component getLazyLoadComponent(String id)
               {
                  return new PositionTab(id);
               }
            };
//            return new PositionTab(panelId);
         }
      });
      tabs.add(new AbstractTab(new ResourceModel("name.tab"))
      {
         @Override
         public WebMarkupContainer getPanel(String panelId)
         {
            return new AjaxLazyLoadPanel(panelId)
            {
               @Override
               public Component getLazyLoadComponent(String id)
               {
                  return new NameTab(id);
               }
            };
//            return new NameTab(panelId);
         }
      });
      tabs.add(new AbstractTab(new ResourceModel("surname.tab"))
      {
         @Override
         public WebMarkupContainer getPanel(String panelId)
         {
            return new AjaxLazyLoadPanel(panelId)
            {
               @Override
               public Component getLazyLoadComponent(String id)
               {
                  return new SurnameTab(id);
               }
            };
//            return new SurnameTab(panelId);
         }
      });
      tabs.add(new AbstractTab(new ResourceModel("parameter.tab"))
      {
         @Override
         public WebMarkupContainer getPanel(String panelId)
         {
            return new AjaxLazyLoadPanel(panelId)
            {
               @Override
               public Component getLazyLoadComponent(String id)
               {
                  return new ParameterTab(id);
               }
            };
//            return new ParameterTab(panelId);
         }
      });

      BootstrapTabbedPanel tabbedPanel = new BootstrapTabbedPanel("tabbed", tabs);
      add(tabbedPanel);
   }

   @Override
   protected BootstrapBreadcrumbPanel provideBreadcrumb(String id)
   {
      return new ConfigBreadcrumb(id);
   }
}
