package com.football.manager.admin.navigation;

import com.football.manager.admin.api.AdminApiKeys;
import com.football.manager.admin.pages.LeagueDetailsPage;
import com.football.manager.domain.League;
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
