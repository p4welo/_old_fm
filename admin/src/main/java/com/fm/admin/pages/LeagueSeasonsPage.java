package com.fm.admin.pages;

import com.fm.admin.cmp.breadcrumb.LeagueDetailsBreadcrumb;
import com.fm.core.cmp.breadcrumb.BootstrapBreadcrumbPanel;
import com.fm.domain.League;
import com.fm.service.ILeagueService;
import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * User: pawel.radomski
 * Date: 19.04.13
 * Time: 16:22
 */
public class LeagueSeasonsPage extends AdminAbstractPage
{
   @SpringBean
   private ILeagueService leagueService;

   private League league;

   public LeagueSeasonsPage(final PageParameters parameters)
   {
      league = getLeague(parameters);
      initView();
   }

   private void initView()
   {
      //To change body of created methods use File | Settings | File Templates.
   }

   private League getLeague(PageParameters parameters)
   {
      String sid = parameters.get(SELECTED_LEAGUE_SID_KEY).toString();
      if (StringUtils.isNotBlank(sid))
      {
         league = leagueService.getBySid(sid);
         if (league == null)
         {
            throw new RestartResponseAtInterceptPageException(LeagueListPage.class);
         }
         return league;
      }
      else
      {
         throw new RestartResponseAtInterceptPageException(LeagueListPage.class);
      }
   }

   @Override
   protected BootstrapBreadcrumbPanel provideBreadcrumb(String id)
   {
      return new LeagueDetailsBreadcrumb(id);
   }
}
