package com.football.manager.server.navigation;

import com.football.manager.domain.League;
import com.football.manager.server.api.AdminApiKeys;
import com.football.manager.server.pages.LeagueDetailsPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * User: pawel.radomski
 * Date: 21.02.13
 * Time: 19:27
 */
public class NavigateToLeagueDetailsPage extends NavigateAction
{
   private final League league;

   public NavigateToLeagueDetailsPage(League league)
   {
      super(LeagueDetailsPage.class);
      this.league = league;
   }

   @Override
   public PageParameters getPageParameters()
   {
      PageParameters pageParameters = new PageParameters();
      pageParameters.add(AdminApiKeys.SELECTED_LEAGUE_ID_KEY, league.getId());
      return pageParameters;
   }
}
