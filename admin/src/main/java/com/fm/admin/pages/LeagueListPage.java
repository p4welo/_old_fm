package com.fm.admin.pages;

import com.fm.admin.api.AdminApiMappings;
import com.fm.admin.cmp.table.AjaxDataTable;
import com.fm.admin.cmp.table.DataProvider;
import com.fm.admin.cmp.window.CreateNewLeagueModal;
import com.fm.admin.navigation.NavigateToLeagueDetailsPage;
import com.fm.domain.DataEntity;
import com.fm.domain.League;
import com.fm.service.ILeagueService;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.WebMarkupContainer;
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
@AuthorizeInstantiation("ROLE_ADMIN")
public class LeagueListPage extends AbstractPage
{
   @SpringBean
   private ILeagueService leagueService;

   private final WebMarkupContainer mainContainer;

   public LeagueListPage()
   {
      super();
      mainContainer = new WebMarkupContainer("mainContainer");
      mainContainer.setOutputMarkupId(true);

      initView();
   }

   private void initView()
   {
      createNewLeagueWindow();
      createLeagueTable();

      add(mainContainer);
   }

   private void createNewLeagueWindow()
   {
      mainContainer.add(new CreateNewLeagueModal("myModal"));
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

      mainContainer.add(new AjaxDataTable<League>("table", columns, new DataProvider<League>(leagueService), 10)
      {
         @Override
         protected void executeOnClick(AjaxRequestTarget target, IModel<League> model)
         {
            new NavigateToLeagueDetailsPage(model.getObject()).navigate();
         }
      });
   }
}