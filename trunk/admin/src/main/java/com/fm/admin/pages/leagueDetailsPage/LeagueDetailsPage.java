package com.fm.admin.pages.leagueDetailsPage;

import com.fm.admin.api.AdminApiMappings;
import com.fm.admin.cmp.breadcrumb.LeagueSeasonBreadcrumb;
import com.fm.admin.pages.AdminAbstractPage;
import com.fm.admin.pages.leagueDetailsPage.cmp.tabbedPanel.MatchesTab;
import com.fm.admin.pages.leagueDetailsPage.cmp.tabbedPanel.TableTab;
import com.fm.admin.pages.leagueListPage.LeagueListPage;
import com.fm.core.cmp.authorization.UserAuthorities;
import com.fm.core.cmp.breadcrumb.BootstrapBreadcrumbPanel;
import com.fm.core.cmp.tabbedPanel.BootstrapTabbedPanel;
import com.fm.domain.League;
import com.fm.service.ILeagueService;
import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.Component;
import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.extensions.ajax.markup.html.AjaxLazyLoadPanel;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

import java.util.ArrayList;
import java.util.List;

/**
 * User: pawel.radomski
 * Date: 19.04.13
 * Time: 16:22
 */
@MountPath(AdminApiMappings.LEAGUE_SEASON_PAGE)
@AuthorizeInstantiation(UserAuthorities.ADMIN)
public class LeagueDetailsPage extends AdminAbstractPage
{
   @SpringBean
   private ILeagueService leagueService;

   private League league;

   public LeagueDetailsPage(final PageParameters parameters)
   {
      super();
      league = getLeague(parameters);
      initView();
   }

   private void initView()
   {
      List<ITab> tabs = new ArrayList<ITab>();
      tabs.add(new AbstractTab(new ResourceModel("active.tab"))
      {
         @Override
         public WebMarkupContainer getPanel(String id)
         {
            AjaxLazyLoadPanel panel = new AjaxLazyLoadPanel(id)
            {
               @Override
               public Component getLazyLoadComponent(String id)
               {
                  return new TableTab(id, new PropertyModel<League>(LeagueDetailsPage.this, "league"));
               }
            };
//            panel.setOutputMarkupId(true);
//            panel.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(2)));
            return panel;
         }
      });
      tabs.add(new AbstractTab(new ResourceModel("matches.tab"))
      {
         @Override
         public WebMarkupContainer getPanel(String id)
         {
            AjaxLazyLoadPanel panel = new AjaxLazyLoadPanel(id)
            {
               @Override
               public Component getLazyLoadComponent(String id)
               {
                  return new MatchesTab(id, new PropertyModel<League>(LeagueDetailsPage.this, "league"));
               }
            };
            return panel;
         }
      });
      add(new BootstrapTabbedPanel("tabs", tabs));
   }

   private League getLeague(PageParameters parameters)
   {
      String sid = parameters.get(SELECTED_LEAGUE_SID_KEY).toString();
      if (StringUtils.isNotBlank(sid))
      {
         league = leagueService.getBySid(sid);
         if (league == null)
         {
            throw new RestartResponseAtInterceptPageException(LeagueListPage.class);
         }
         return league;
      }
      else
      {
         throw new RestartResponseAtInterceptPageException(LeagueListPage.class);
      }
   }

   @Override
   protected BootstrapBreadcrumbPanel provideBreadcrumb(String id)
   {
      return new LeagueSeasonBreadcrumb(id);
   }
}
