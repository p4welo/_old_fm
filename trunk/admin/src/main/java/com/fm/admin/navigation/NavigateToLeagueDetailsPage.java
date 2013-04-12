package com.fm.admin.navigation;

import com.fm.admin.api.AdminApiKeys;
import com.fm.admin.pages.LeagueDetailsPage;
import com.fm.core.navigation.NavigateAction;
import com.fm.domain.League;
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
      pageParameters.add(AdminApiKeys.SELECTED_LEAGUE_SID_KEY, league.getSid());
      return pageParameters;
   }
}
