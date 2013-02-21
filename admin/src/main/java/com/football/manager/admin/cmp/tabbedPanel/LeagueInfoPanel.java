package com.football.manager.admin.cmp.tabbedPanel;

import com.football.manager.domain.League;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;

/**
 * User: pawel.radomski
 * Date: 21.02.13
 * Time: 20:06
 */
public class LeagueInfoPanel extends Panel
{
   private League league;

   public LeagueInfoPanel(String id, League league)
   {
      super(id);
      this.league = league;
      add(new Label("name", new PropertyModel(this, "league." + League.FIELD_NAME)));
   }

   public League getLeague()
   {
      return league;
   }

   public void setLeague(League league)
   {
      this.league = league;
   }
}
