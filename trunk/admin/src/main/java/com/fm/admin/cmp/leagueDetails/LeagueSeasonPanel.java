package com.fm.admin.cmp.leagueDetails;

import com.fm.admin.cmp.window.CreateNewSeasonModal;
import com.fm.admin.pages.LeagueDetailsPage;
import com.fm.domain.Season;
import com.fm.domain.Team;
import com.fm.domain.TeamRecord;
import com.fm.service.ISeasonService;
import com.fm.service.ITeamRecordService;
import com.fm.service.ITeamService;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.List;

/**
 * User: pawel
 * Date: 28.01.13
 * Time: 21:47
 */
public class LeagueSeasonPanel extends Panel
{
   @SpringBean
   private ISeasonService seasonService;

   @SpringBean
   private ITeamRecordService teamRecordService;

   @SpringBean
   private ITeamService teamService;

   private final WebMarkupContainer mainContainer;

   private final WebMarkupContainer leftContainer;

   private final WebMarkupContainer rightContainer;

   private final LeagueDetailsPage leagueDetailsPage;

   private Season selectedSeason;

   private List<TeamRecord> teamRecords;

   private ListView<TeamRecord> teamListView;

   private DropDownChoice<Season> seasons;

   private List<Season> allSeasons;

   public LeagueSeasonPanel(String id, LeagueDetailsPage leagueDetailsPage)
   {
      super(id);
      this.leagueDetailsPage = leagueDetailsPage;
      allSeasons = seasonService.getLeagueSeasons(leagueDetailsPage.getLeague());
      selectedSeason = seasonService.getActiveSeason(leagueDetailsPage.getLeague());

      mainContainer = new WebMarkupContainer("mainContainer");
      leftContainer = new WebMarkupContainer("leftContainer");
      rightContainer = new WebMarkupContainer("rightContainer");

      initView();
   }

   private void initView()
   {
      setOutputMarkupId(true);
      mainContainer.setOutputMarkupId(true);
      leftContainer.add(createNewSeasonWindow());
      leftContainer.setOutputMarkupId(true);
      rightContainer.setOutputMarkupId(true);

      createSeasonsCombo(leftContainer);
      createTeamRecordTable(leftContainer);

      mainContainer.add(leftContainer);
      mainContainer.add(rightContainer);
      add(mainContainer);
   }

   private CreateNewSeasonModal createNewSeasonWindow()
   {
      List<Team> teams = teamService.findTeamsFromLeague(selectedSeason.getLeague());
      return new CreateNewSeasonModal("myModal", leagueDetailsPage.getLeague(), teams);
   }

   private void createSeasonsCombo(WebMarkupContainer container)
   {
      seasons = new DropDownChoice<Season>(
              "seasons",
              new PropertyModel<Season>(this, "selectedSeason"),
              new PropertyModel(this, "allSeasons"), new ChoiceRenderer<Season>(Season.FIELD_NUMBER));
      seasons.add(new AjaxFormComponentUpdatingBehavior("change")
      {
         @Override
         protected void onUpdate(AjaxRequestTarget target)
         {
            teamRecords = teamRecordService.findTeamRecordsBySeason(selectedSeason);
            target.add(leagueDetailsPage.getMainContainer());
         }
      });
      seasons.setOutputMarkupId(true);
      container.add(seasons);
   }

   private void createTeamRecordTable(WebMarkupContainer container)
   {
      teamRecords = teamRecordService.findTeamRecordsBySeason(selectedSeason);
      teamListView = new ListView<TeamRecord>("teams",
              new PropertyModel<List<? extends TeamRecord>>(this, "teamRecords"))
      {
         @Override
         protected void populateItem(ListItem<TeamRecord> item)
         {
            final TeamRecord teamRecord = item.getModelObject();
            item.add(new Label("name", new PropertyModel<String>(teamRecord, TeamRecord.FIELD_TEAM_NAME)));
            item.add(new Label("round", new PropertyModel<String>(teamRecord, TeamRecord.FIELD_ROUND_NUMBER)));
            item.add(new Label("points", new PropertyModel<String>(teamRecord, TeamRecord.FIELD_POINTS_COUNT)));
            item.add(new Label("goalsScored", new PropertyModel<String>(teamRecord, TeamRecord.FIELD_GOALS_SCORED)));
            item.add(new Label("goalsAllowed", new PropertyModel<String>(teamRecord, TeamRecord.FIELD_GOALS_ALLOWED)));
            item.add(new Label("goalsDifference",
                    new PropertyModel<String>(teamRecord, TeamRecord.FIELD_GOALS_DIFFERENCE)));
            item.add(new Label("wins", new PropertyModel<String>(teamRecord, TeamRecord.FIELD_WINS_COUNT)));
            item.add(new Label("draws", new PropertyModel<String>(teamRecord, TeamRecord.FIELD_DRAWS_COUNT)));
            item.add(new Label("loses", new PropertyModel<String>(teamRecord, TeamRecord.FIELD_LOSES_COUNT)));
         }
      };
      container.add(teamListView);
   }

   public Season getSelectedSeason()
   {
      return selectedSeason;
   }

   public void setSelectedSeason(Season selectedSeason)
   {
      this.selectedSeason = selectedSeason;
   }

   public List<TeamRecord> getTeamRecords()
   {
      return teamRecords;
   }

   public void setTeamRecords(List<TeamRecord> teamRecords)
   {
      this.teamRecords = teamRecords;
   }
}
