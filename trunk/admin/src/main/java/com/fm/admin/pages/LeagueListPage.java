package com.fm.admin.pages;

import com.fm.admin.api.AdminApiMappings;
import com.fm.admin.cmp.breadcrumb.LeagueListBreadcrumb;
import com.fm.admin.cmp.leagueDetails.window.NewLeagueWindow;
import com.fm.admin.navigation.NavigateToLeagueDetailsPage;
import com.fm.core.cmp.authorization.UserRoles;
import com.fm.core.cmp.breadcrumb.BootstrapBreadcrumbPanel;
import com.fm.core.cmp.feedback.NotifyFeedbackPanel;
import com.fm.core.cmp.table.AjaxDataTable;
import com.fm.core.cmp.table.DataProvider;
import com.fm.domain.DataEntity;
import com.fm.domain.League;
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
@AuthorizeInstantiation(UserRoles.ADMIN)
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
            leagueService.save(league, getGenerateTeams());
            success(getString("league.successfully.saved"));

            resetState();
            target.add(main);
         }
      };
      main.add(window);
      main.add(new NotifyFeedbackPanel("feedback"));
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

      main.add(new AjaxDataTable<League>("table", columns, new DataProvider<League>(leagueService), 10)
      {
         @Override
         protected void executeOnClick(AjaxRequestTarget target, IModel<League> model)
         {
            new NavigateToLeagueDetailsPage(model.getObject()).navigate();
         }
      });
   }
}