package com.football.manager.admin.pages.cmp.tabbedPanel;

import com.football.manager.admin.pages.LeagueDetailsPage;
import com.football.manager.admin.pages.cmp.window.CreateNewTeamWindow;
import com.football.manager.domain.League;
import com.football.manager.domain.Team;
import com.football.manager.service.ILeagueService;
import com.football.manager.service.ITeamService;
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
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.List;

/**
 * User: pawel
 * Date: 28.01.13
 * Time: 21:57
 */
public class LeagueDetailsTabPanel extends Panel
{
   @SpringBean
   private ILeagueService leagueService;

   @SpringBean
   private ITeamService teamService;

   private final WebMarkupContainer mainContainer;

   private final WebMarkupContainer leftContainer;

   private final WebMarkupContainer rightContainer;

   private final LeagueDetailsPage leagueDetailsPage;

   private CreateNewTeamWindow createNewTeamWindow;

   private List<Team> teamList;

   private ListView<Team> teamListView;

   private Team selectedTeam;

   public LeagueDetailsTabPanel(String id, LeagueDetailsPage leagueDetailsPage)
   {
      super(id);
      this.leagueDetailsPage = leagueDetailsPage;

      mainContainer = new WebMarkupContainer("mainContainer");
      mainContainer.setOutputMarkupId(true);
      leftContainer = new WebMarkupContainer("leftContainer");
      leftContainer.setOutputMarkupId(true);
      rightContainer = new WebMarkupContainer("rightContainer");
      rightContainer.setOutputMarkupId(true);

      initView();
   }

   private void initView()
   {
      createNewTeamWindow();
      createPageHeader(mainContainer);
      createTableToolbar(leftContainer);
      createTeamTable(leftContainer);
      createLeaguePropertiesForm(rightContainer);

      mainContainer.add(leftContainer);
      mainContainer.add(rightContainer);
      add(mainContainer);
   }

   private void createPageHeader(WebMarkupContainer container)
   {
      mainContainer.add(new Label("leagueName", new PropertyModel<String>(leagueDetailsPage, "selectedLeague.name")));
   }

   private void createTeamTable(WebMarkupContainer container)
   {
      teamList = teamService.findTeamsFromLeague(leagueDetailsPage.getSelectedLeague());
      teamListView = new ListView<Team>("teams", teamList)
      {
         @Override
         protected void populateItem(ListItem<Team> item)
         {
            final Team team = item.getModelObject();
//            item.add(new Label("id", new PropertyModel<String>(team, Team.FIELD_ID)));
            item.add(new Label("name", new PropertyModel<String>(team, Team.FIELD_NAME)));
            item.add(new Label("account", new PropertyModel<String>(team, Team.FIELD_ACCOUNT)));
         }
      };
      container.add(teamListView);
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
            team.setLeague(leagueService.update(leagueDetailsPage.getSelectedLeague()));
            team = teamService.save(team);
            teamList.add(team);
            target.add(leagueDetailsPage.getMainContainer());
         }
      };
      add(createNewTeamWindow);
   }

   private void createLeaguePropertiesForm(WebMarkupContainer container)
   {
      Form form = new Form<Void>("leaguePropertiesForm");
      final TextField leagueNameField = new TextField("leagueNameField",
              new PropertyModel(leagueDetailsPage, "selectedLeague.name"));
      form.add(leagueNameField);
      form.add(new AjaxButton("submitButton", form)
      {
         @Override
         protected void onSubmit(AjaxRequestTarget target, Form<?> form)
         {
            League selectedLeague = leagueDetailsPage.getSelectedLeague();
            leagueService.update(selectedLeague);
            success((new ResourceModel("successfully.updated.league.properties")).getObject());
            target.add(leagueDetailsPage.getMainContainer());
         }
      });
      FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
      feedbackPanel.setOutputMarkupId(true);
      form.add(feedbackPanel);
      container.add(form);
   }

   private void createTableToolbar(WebMarkupContainer container)
   {
      container.add(new AjaxLink<Void>("newTeamLink")
      {
         @Override
         public void onClick(AjaxRequestTarget ajaxRequestTarget)
         {
            createNewTeamWindow.show(ajaxRequestTarget);
         }
      });
   }
}
