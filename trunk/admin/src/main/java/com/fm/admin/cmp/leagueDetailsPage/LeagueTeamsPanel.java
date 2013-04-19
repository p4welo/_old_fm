package com.fm.admin.cmp.leagueDetailsPage;

import com.fm.domain.League;
import com.fm.domain.Team;
import com.fm.service.ITeamService;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.List;

/**
 * User: pawel
 * Date: 28.01.13
 * Time: 21:57
 */
public class LeagueTeamsPanel extends Panel
{
   @SpringBean
   private ITeamService teamService;

   private final WebMarkupContainer mainContainer;

   private List<Team> teams;

   private League league;

   public LeagueTeamsPanel(String id, League league)
   {
      super(id);
      this.league = league;
      mainContainer = new WebMarkupContainer("mainContainer");
      mainContainer.setOutputMarkupId(true);

      initView();
   }

   private void initView()
   {
      mainContainer.add(createTeamTable());
      add(mainContainer);
   }

   private ListView<Team> createTeamTable()
   {
      ListView<Team> teamListView = new ListView<Team>("teams", new PropertyModel<List<Team>>(this, "teams"))
      {
         @Override
         protected void onBeforeRender()
         {
            teams = teamService.findTeamsFromLeague(league);
            super.onBeforeRender();
         }

         @Override
         protected void populateItem(ListItem<Team> item)
         {
            final Team team = item.getModelObject();
            item.add(new Label("name", new PropertyModel<String>(team, Team.FIELD_NAME)));
            item.add(new Label("account", new PropertyModel<String>(team, Team.FIELD_ACCOUNT)));
         }
      };
      return teamListView;
   }
}
