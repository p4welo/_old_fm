package com.football.manager.admin.pages;

import com.football.manager.admin.api.AdminApiMappings;
import com.football.manager.admin.pages.cmp.window.CreateNewTeamWindow;
import com.football.manager.domain.League;
import com.football.manager.domain.Team;
import com.football.manager.service.ILeagueService;
import com.football.manager.service.ITeamService;
import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

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

   private Team selectedTeam;

   private ListView<Team> teamListView;

   private List<Team> teamList;

   private final WebMarkupContainer mainContainer;

   private final WebMarkupContainer leftContainer;

   private final WebMarkupContainer rightContainer;

   private CreateNewTeamWindow createNewTeamWindow;

   public LeagueDetailsPage(final PageParameters parameters)
   {
      super();
      mainContainer = new WebMarkupContainer("mainContainer");
      mainContainer.setOutputMarkupId(true);
      leftContainer = new WebMarkupContainer("leftContainer");
      leftContainer.setOutputMarkupId(true);
      rightContainer = new WebMarkupContainer("rightContainer");
      rightContainer.setOutputMarkupId(true);

      handleIncomingParameters(parameters);
      initView();
   }

   private void initView()
   {
      createPageHeader();
      createNewTeamWindow();
      createTableToolbar();
      createTeamTable();
      createLeaguePropertiesForm();

      mainContainer.add(leftContainer);
      mainContainer.add(rightContainer);
      add(mainContainer);
   }

   private void createPageHeader()
   {
      mainContainer.add(new Label("leagueName", selectedLeague.getName()));
   }

   private void createLeaguePropertiesForm()
   {
      Form form = new Form<Void>("leaguePropertiesForm");
      final TextField leagueNameField = new TextField("leagueNameField",
              new PropertyModel(selectedLeague, League.FIELD_NAME));
      form.add(leagueNameField);
      form.add(new AjaxButton("submitButton", form)
      {
         @Override
         protected void onSubmit(AjaxRequestTarget target, Form<?> form)
         {
            leagueService.update(selectedLeague);
            success((new ResourceModel("successfully.updated.league.properties")).getObject());
            target.add(mainContainer);
         }
      });
      FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
      feedbackPanel.setOutputMarkupId(true);
      form.add(feedbackPanel);
      rightContainer.add(form);
   }

   private void createTeamTable()
   {
      teamList = teamService.findTeamsFromLeague(selectedLeague);
      teamListView = new ListView<Team>("teams", teamList)
      {
         @Override
         protected void populateItem(ListItem<Team> item)
         {
            final Team team = item.getModelObject();
            item.add(new Label("id", new PropertyModel<String>(team, Team.FIELD_ID)));
            item.add(new Label("name", new PropertyModel<String>(team, Team.FIELD_NAME)));
            item.add(new Label("account", new PropertyModel<String>(team, Team.FIELD_ACCOUNT)));
         }
      };
      leftContainer.add(teamListView);
   }

   private void createTableToolbar()
   {
      leftContainer.add(new AjaxLink<Void>("newTeamLink")
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
            teamList.add(team);
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

   public League getSelectedLeague()
   {
      return selectedLeague;
   }

   public void setSelectedLeague(League selectedLeague)
   {
      this.selectedLeague = selectedLeague;
   }

   public Team getSelectedTeam()
   {
      return selectedTeam;
   }

   public void setSelectedTeam(Team selectedTeam)
   {
      this.selectedTeam = selectedTeam;
   }
}
