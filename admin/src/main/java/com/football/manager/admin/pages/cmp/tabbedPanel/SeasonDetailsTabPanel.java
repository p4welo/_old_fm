package com.football.manager.admin.pages.cmp.tabbedPanel;

import com.football.manager.admin.pages.LeagueDetailsPage;
import com.football.manager.domain.Season;
import com.football.manager.domain.TeamRecord;
import com.football.manager.service.ISeasonService;
import com.football.manager.service.ITeamRecordService;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
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
public class SeasonDetailsTabPanel extends Panel
{
   @SpringBean
   private ISeasonService seasonService;

   @SpringBean
   private ITeamRecordService teamRecordService;

   private final WebMarkupContainer mainContainer;

   private final WebMarkupContainer leftContainer;

   private final WebMarkupContainer rightContainer;

   private final LeagueDetailsPage leagueDetailsPage;

   private Season selectedSeason;

   private List<TeamRecord> teamRecords;

   private ListView<TeamRecord> teamListView;

   private DropDownChoice<Season> seasons;

   private List<Season> allSeasons;

   public SeasonDetailsTabPanel(String id, LeagueDetailsPage leagueDetailsPage)
   {
      super(id);
      setOutputMarkupId(true);
      this.leagueDetailsPage = leagueDetailsPage;
      allSeasons = seasonService.getLeagueSeasons(leagueDetailsPage.getSelectedLeague());
      selectedSeason = seasonService.getActiveSeason(leagueDetailsPage.getSelectedLeague());

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
      createTableToolbar(leftContainer);
      createSeasonsCombo(leftContainer);
      createTeamRecordTable(leftContainer);

      mainContainer.add(leftContainer);
      mainContainer.add(rightContainer);
      add(mainContainer);
   }

   private void createSeasonsCombo(WebMarkupContainer container)
   {

      seasons = new DropDownChoice<Season>(
              "seasons",
              new PropertyModel<Season>(this, "selectedSeason"),
              new PropertyModel(this, "allSeasons"));
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

   private void createTableToolbar(WebMarkupContainer container)
   {
      container.add(new AjaxLink<Void>("newSeasonLink")
      {
         @Override
         public void onClick(AjaxRequestTarget ajaxRequestTarget)
         {
//            TODO czy utworzyc nową ligę?
            Season season = new Season();
            season.setLeague(leagueDetailsPage.getSelectedLeague());
            selectedSeason = seasonService.save(season);
            teamRecords = teamRecordService.findTeamRecordsBySeason(selectedSeason);
            ajaxRequestTarget.add(leagueDetailsPage.getMainContainer());
         }
      });
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
