package com.fm.admin.pages.teamDetailsPage;

import com.fm.admin.api.AdminApiKeys;
import com.fm.admin.api.AdminApiMappings;
import com.fm.admin.cmp.breadcrumb.LeagueDetailsBreadcrumb;
import com.fm.admin.pages.AdminAbstractPage;
import com.fm.admin.pages.leagueDetailsPage.LeagueDetailsPage;
import com.fm.admin.pages.teamDetailsPage.cmp.tabPanel.PlayersTab;
import com.fm.core.cmp.authorization.UserAuthorities;
import com.fm.core.cmp.breadcrumb.BootstrapBreadcrumbPanel;
import com.fm.core.cmp.tabbedPanel.BootstrapTabbedPanel;
import com.fm.domain.Player;
import com.fm.domain.Team;
import com.fm.service.IPlayerService;
import com.fm.service.ITeamService;
import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.Component;
import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.extensions.ajax.markup.html.AjaxLazyLoadPanel;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 13.05.13
 * Time: 21:28
 * To change this template use File | Settings | File Templates.
 */
@MountPath(AdminApiMappings.TEAM_DETAILS_PAGE)
@AuthorizeInstantiation(UserAuthorities.ADMIN)
public class TeamDetailsPage extends AdminAbstractPage
{
   @SpringBean
   private IPlayerService playerService;

   @SpringBean
   private ITeamService teamService;

   private List<Player> players;

   public TeamDetailsPage(PageParameters parameters)
   {
      super();
      Team team = getTeam(parameters);
      setDefaultModel(new Model<Team>(team));
   }

   @Override
   protected void onInitialize()
   {
      super.onInitialize();
      List<ITab> tabs = new ArrayList<ITab>();
      tabs.add(new AbstractTab(new ResourceModel("players.tab"))
      {
         @Override
         public WebMarkupContainer getPanel(String panelId)
         {
            return new AjaxLazyLoadPanel(panelId)
            {
               @Override
               public Component getLazyLoadComponent(String markupId)
               {
                  return new PlayersTab(markupId, (IModel<Team>) TeamDetailsPage.this.getDefaultModel());
               }
            };
         }
      });
      add(new BootstrapTabbedPanel("tab", tabs));
   }

   private Team getTeam(PageParameters parameters)
   {
      String sid = parameters.get(AdminApiKeys.SELECTED_TEAM_SID_KEY).toString();
      if (StringUtils.isNotBlank(sid))
      {
         Team team = teamService.getBySid(sid);
         if (team == null)
         {
            throw new RestartResponseAtInterceptPageException(LeagueDetailsPage.class);
         }
         return team;
      }
      else
      {
         throw new RestartResponseAtInterceptPageException(LeagueDetailsPage.class);
      }
   }

   @Override
   protected BootstrapBreadcrumbPanel provideBreadcrumb(String id)
   {
      return new LeagueDetailsBreadcrumb(id);
   }
}
