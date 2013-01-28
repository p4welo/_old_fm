package com.football.manager.admin.pages;

import com.football.manager.admin.api.AdminApiMappings;
import com.football.manager.admin.pages.cmp.table.AjaxDataTable;
import com.football.manager.admin.pages.cmp.table.DataProvider;
import com.football.manager.admin.pages.cmp.window.CreateNewTeamWindow;
import com.football.manager.domain.DataEntity;
import com.football.manager.domain.League;
import com.football.manager.domain.Team;
import com.football.manager.service.ILeagueService;
import com.football.manager.service.ITeamService;
import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

import java.util.ArrayList;
import java.util.List;

/**
 * User: pawel
 * Date: 27.01.13
 * Time: 00:05
 */
@MountPath(AdminApiMappings.LEAGUE_DETAILS_PAGE)
public class LeagueDetailsPage extends AbstractPage
{
   @SpringBean
   private ITeamService teamService;

   @SpringBean
   private ILeagueService leagueService;

   private League selectedLeague;

   private final WebMarkupContainer mainContainer;

   private CreateNewTeamWindow createNewTeamWindow;

   public LeagueDetailsPage(final PageParameters parameters)
   {
      super();
      mainContainer = new WebMarkupContainer("mainContainer");
      mainContainer.setOutputMarkupId(true);

      handleIncomingParameters(parameters);
      initView();
   }

   private void initView()
   {
      add(new Label("leagueName", selectedLeague.getName()));
      createNewTeamWindow();
      createTableToolbar();
      createTeamTable();
      add(mainContainer);
   }

   private void createTeamTable()
   {
      List<IColumn<Team, String>> columns = new ArrayList<IColumn<Team, String>>();

      columns.add(new PropertyColumn<Team, String>(new ResourceModel("table.team.id.column.header"),
              DataEntity.FIELD_ID, DataEntity.FIELD_ID));
      columns.add(new PropertyColumn<Team, String>(new ResourceModel("table.team.name.column.header"),
              Team.FIELD_NAME, Team.FIELD_NAME));
      columns.add(new PropertyColumn<Team, String>(new ResourceModel("table.team.league.column.header"),
              Team.FIELD_LEAGUE, Team.FIELD_LEAGUE + "." + League.FIELD_NAME));

      mainContainer.add(new AjaxDataTable<Team>("table", columns, new DataProvider<Team>(teamService), 10));
   }

   private void createTableToolbar()
   {
      mainContainer.add(new AjaxLink<Void>("newTeamLink")
      {
         @Override
         public void onClick(AjaxRequestTarget ajaxRequestTarget)
         {
            createNewTeamWindow.show(ajaxRequestTarget);
         }
      });
   }

   private void createNewTeamWindow()
   {
      createNewTeamWindow = new CreateNewTeamWindow("createNewTeamWindow")
      {
         @Override
         protected void onConfirm(AjaxRequestTarget target)
         {
            Team team = new Team();
            team.setName(createNewTeamWindow.getTeamName());
            team.setAccount(createNewTeamWindow.getTeamAccount());
            team.setLeague(leagueService.update(selectedLeague));
            team = teamService.save(team);
            target.add(mainContainer);
         }
      };
      add(createNewTeamWindow);
   }

   private void handleIncomingParameters(PageParameters parameters)
   {
      String idString = parameters.get(SELECTED_LEAGUE_ID_KEY).toString();
      if (StringUtils.isNotBlank(idString))
      {
         Long id = Long.valueOf(idString);
         selectedLeague = leagueService.getById(id);
         if (selectedLeague == null)
         {
            throw new RestartResponseAtInterceptPageException(LeagueListPage.class);
         }
      }
      else
      {
         throw new RestartResponseAtInterceptPageException(LeagueListPage.class);
      }
   }
}
