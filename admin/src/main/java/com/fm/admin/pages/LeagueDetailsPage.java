package com.fm.admin.pages;

import com.fm.admin.api.AdminApiMappings;
import com.fm.admin.cmp.breadcrumb.LeagueDetailsBreadcrumb;
import com.fm.admin.cmp.leagueDetails.LeagueInfoPanel;
import com.fm.admin.cmp.leagueDetails.LeagueTeamsPanel;
import com.fm.admin.cmp.window.NewTeamWindow;
import com.fm.core.cmp.breadcrumb.BootstrapBreadcrumbPanel;
import com.fm.domain.League;
import com.fm.domain.Team;
import com.fm.service.ILeagueService;
import com.fm.service.ITeamService;
import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

/**
 * User: pawel
 * Date: 27.01.13
 * Time: 00:05
 */

@MountPath(AdminApiMappings.LEAGUE_DETAILS_PAGE)
@AuthorizeInstantiation("ROLE_ADMIN")
public class LeagueDetailsPage extends AdminAbstractPage
{
   @SpringBean
   private ILeagueService leagueService;

   @SpringBean
   private ITeamService teamService;

   private NewTeamWindow window;

   private League league;

   private final WebMarkupContainer mainContainer;

   public LeagueDetailsPage(final PageParameters parameters)
   {
      super();
      mainContainer = new WebMarkupContainer("mainContainer");
      mainContainer.setOutputMarkupId(true);

      league = getLeague(parameters);
      initView();
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

   private void initView()
   {
      window = new NewTeamWindow("window", getString("create.team"), league)
      {
         @Override
         public void onSubmit(AjaxRequestTarget target, Form<?> form)
         {
            Team team = getTeam();
            teamService.save(team);

            success(getString("team.successfully.saved"));

            resetState();
            target.add(mainContainer);
         }
      };
      add(window);
      mainContainer.add(new LeagueInfoPanel("info", league));
      mainContainer.add(new LeagueTeamsPanel("teams", league));
      mainContainer.add(new AjaxLink<Void>("newTeam")
      {
         @Override
         public void onClick(AjaxRequestTarget target)
         {
            window.show(target);
         }
      });
      add(mainContainer);
   }

   public League getLeague()
   {
      return league;
   }

   public void setLeague(League league)
   {
      this.league = league;
   }

   public WebMarkupContainer getMainContainer()
   {
      return mainContainer;
   }

   @Override
   protected BootstrapBreadcrumbPanel provideBreadcrumb(String id)
   {
      return new LeagueDetailsBreadcrumb(id);
   }
}
