package com.fm.admin.navigation;

import com.fm.admin.api.AdminApiKeys;
import com.fm.admin.pages.teamDetailsPage.TeamDetailsPage;
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
   private String teamSid;

   public NavigateToTeamDetailsPage(Team team)
   {
      this(team.getSid());
   }

   public NavigateToTeamDetailsPage(String teamSid)
   {
      super(TeamDetailsPage.class);
      this.teamSid = teamSid;
   }

   @Override
   public PageParameters getPageParameters()
   {
      PageParameters pageParameters = new PageParameters();
      pageParameters.add(AdminApiKeys.SELECTED_TEAM_SID_KEY, teamSid);
      return pageParameters;
   }
}
