package com.fm.admin.cmp.leagueSeasonsPage.tabbedPanel;

import com.fm.domain.League;
import com.fm.domain.Season;
import com.fm.domain.TeamRecord;
import com.fm.service.ISeasonService;
import com.fm.service.ITeamRecordService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.List;

/**
 * User: pawel.radomski
 * Date: 19.04.13
 * Time: 16:47
 */
public class ActualSeasonTab extends Panel
{
   @SpringBean
   private ISeasonService seasonService;

   @SpringBean
   private ITeamRecordService teamRecordService;

   private League league;

   private Season season;

   private List<TeamRecord> teamRecords;

   public ActualSeasonTab(String id, IModel<League> model)
   {
      super(id, model);
      league = model.getObject();
      season = seasonService.getActiveSeason(league);

      initView();
   }

   private void initView()
   {
      teamRecords = teamRecordService.findTeamRecordsBySeason(season);
      ListView<TeamRecord> teamListView = new ListView<TeamRecord>("teams",
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
      add(teamListView);
   }
}
