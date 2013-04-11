package com.fm.admin.cmp.leagueDetails;

import com.fm.domain.League;
import com.fm.domain.Season;
import com.fm.service.ISeasonService;
import com.fm.service.ITeamService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * User: pawel.radomski
 * Date: 21.02.13
 * Time: 20:06
 */
public class LeagueInfoPanel extends Panel
{
   @SpringBean
   private ITeamService teamService;

   @SpringBean
   private ISeasonService seasonService;

   private League league;

   private Integer teamCount;

   private Season activeSeason;

   public LeagueInfoPanel(String id, League league)
   {
      super(id);
      this.league = league;

      initView();
   }

   @Override
   protected void onBeforeRender()
   {
      teamCount = teamService.getLeagueTeamsCount(league);
      activeSeason = seasonService.getActiveSeason(league);
      super.onBeforeRender();
   }

   private void initView()
   {
      add(new Label("name", new PropertyModel(this, "league." + League.FIELD_NAME)));
      add(new Label("teamCount", new PropertyModel(this, "teamCount")));
      add(new Label("activeSeason", new PropertyModel(this, "activeSeason." + Season.FIELD_NUMBER)));
   }
}
