package com.fm.admin.navigation;

import com.fm.admin.api.AdminApiKeys;
import com.fm.admin.pages.LeagueSeasonsPage;
import com.fm.core.navigation.NavigateAction;
import com.fm.domain.League;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * User: pawel.radomski
 * Date: 19.04.13
 * Time: 16:53
 */
public class NavigateToLeagueSeasonsPage extends NavigateAction
{
   private final League league;

   public NavigateToLeagueSeasonsPage(League league)
   {
      super(LeagueSeasonsPage.class);
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
