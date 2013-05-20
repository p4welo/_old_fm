package com.fm.admin.pages.leagueListPage;

import com.fm.admin.api.AdminApiMappings;
import com.fm.admin.cmp.breadcrumb.LeagueListBreadcrumb;
import com.fm.admin.navigation.NavigateToLeagueSeasonsPage;
import com.fm.admin.pages.AdminAbstractPage;
import com.fm.admin.pages.leagueListPage.cmp.window.NewLeagueWindow;
import com.fm.core.cmp.authorization.UserAuthorities;
import com.fm.core.cmp.breadcrumb.BootstrapBreadcrumbPanel;
import com.fm.core.cmp.newTable.AjaxDataTable;
import com.fm.core.cmp.newTable.DataProvider;
import com.fm.core.cmp.notify.Notification;
import com.fm.domain.DataEntity;
import com.fm.domain.League;
import com.fm.domain.filter.FmFilter;
import com.fm.domain.filter.OpenSearchDescription;
import com.fm.service.ILeagueService;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

import java.util.ArrayList;
import java.util.List;

/**
 * User: pawel
 * Date: 26.01.13
 * Time: 15:00
 */
@MountPath(AdminApiMappings.LEAGUE_LIST_PAGE)
@AuthorizeInstantiation(UserAuthorities.ADMIN)
public class LeagueListPage extends AdminAbstractPage
{
   @SpringBean
   private ILeagueService leagueService;

   private WebMarkupContainer main;

   public LeagueListPage()
   {
      super();
      main = new WebMarkupContainer("main");
      main.setOutputMarkupId(true);
      initView();
   }

   @Override
   protected BootstrapBreadcrumbPanel provideBreadcrumb(String id)
   {
      return new LeagueListBreadcrumb(id);
   }

   private void initView()
   {
      final NewLeagueWindow window = new NewLeagueWindow("newLeagueWindow", getString("create.league"))
      {
         @Override
         public void onSubmit(AjaxRequestTarget target, Form<?> form)
         {
            League league = getLeague();
            leagueService.save(league, getGenerateTeams(), getProgress());
            Notification.success(getString("league.successfully.saved"));

            resetState();
            target.add(main);
         }
      };
      main.add(window);
      main.add(new AjaxLink<Void>("createLeagueLink")
      {
         @Override
         public void onClick(AjaxRequestTarget target)
         {
            window.show(target);
         }
      });
      createLeagueTable();
      add(main);
   }

   private void createLeagueTable()
   {

      List<IColumn<League, String>> columns = new ArrayList<IColumn<League, String>>();

      columns.add(new PropertyColumn<League, String>(
              new ResourceModel("table.league.id.column.header"),
              DataEntity.FIELD_ID,
              DataEntity.FIELD_ID
      ));
      columns.add(new PropertyColumn<League, String>(
              new ResourceModel("table.league.name.column.header"),
              League.FIELD_NAME,
              League.FIELD_NAME
      ));
      OpenSearchDescription<League> osd = new OpenSearchDescription<League>();
      FmFilter filter = new FmFilter();
      osd.setFilter(filter);
      DataProvider dataProvider = new DataProvider(leagueService, osd);

      main.add(new AjaxDataTable<League>("table", columns, dataProvider)
      {
         @Override
         public void executeOnClick(AjaxRequestTarget target, IModel<League> model)
         {
            new NavigateToLeagueSeasonsPage(model.getObject()).navigate();
         }
      });
   }
}