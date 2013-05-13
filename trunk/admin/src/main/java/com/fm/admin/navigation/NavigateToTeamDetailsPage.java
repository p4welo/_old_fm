package com.fm.admin.navigation;

import com.fm.admin.api.AdminApiKeys;
import com.fm.admin.pages.TeamDetailsPage;
import com.fm.core.navigation.NavigateAction;
import com.fm.domain.Team;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 13.05.13
 * Time: 21:31
 * To change this template use File | Settings | File Templates.
 */
public class NavigateToTeamDetailsPage extends NavigateAction
{
   private Team team;

   public NavigateToTeamDetailsPage(Team team)
   {
      super(TeamDetailsPage.class);
      this.team = team;
   }

   @Override
   public PageParameters getPageParameters()
   {
      PageParameters pageParameters = new PageParameters();
      pageParameters.add(AdminApiKeys.SELECTED_TEAM_SID_KEY, team.getSid());
      return pageParameters;
   }
}
