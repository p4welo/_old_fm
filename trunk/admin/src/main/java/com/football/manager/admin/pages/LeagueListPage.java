package com.football.manager.admin.pages;

import com.football.manager.admin.api.AdminApiMappings;
import com.football.manager.admin.pages.cmp.table.AjaxDataTable;
import com.football.manager.admin.pages.cmp.table.DataProvider;
import com.football.manager.admin.pages.cmp.window.CreateNewLeagueWindow;
import com.football.manager.domain.DataEntity;
import com.football.manager.domain.League;
import com.football.manager.service.ILeagueService;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
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
public class LeagueListPage extends AbstractPage
{
   @SpringBean
   private ILeagueService leagueService;

   private final WebMarkupContainer mainContainer;

   private CreateNewLeagueWindow createNewLeagueWindow;

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
      createTableToolbar();
      createLeagueTable();

      add(mainContainer);
   }

   private void createTableToolbar()
   {
      mainContainer.add(new AjaxLink<Void>("newLeagueLink")
      {
         @Override
         public void onClick(AjaxRequestTarget ajaxRequestTarget)
         {
            createNewLeagueWindow.show(ajaxRequestTarget);
         }
      });
   }

   private void createNewLeagueWindow()
   {
      createNewLeagueWindow = new CreateNewLeagueWindow("createNewLeagueWindow")
      {
         @Override
         protected void onConfirm(AjaxRequestTarget target)
         {
            League newLeague = new League();
            newLeague.setName(createNewLeagueWindow.getLeagueName());
            leagueService.save(newLeague);
            target.add(mainContainer);
         }
      };
      add(createNewLeagueWindow);
   }

   private void createLeagueTable()
   {
      List<IColumn<League, String>> columns = new ArrayList<IColumn<League, String>>();

      columns.add(new PropertyColumn<League, String>(new ResourceModel("table.league.id.column.header"),
              DataEntity.FIELD_ID, DataEntity.FIELD_ID));
      columns.add(new PropertyColumn<League, String>(new ResourceModel("table.league.name.column.header"),
              League.FIELD_NAME, League.FIELD_NAME));

      mainContainer.add(new AjaxDataTable<League>("table", columns, new DataProvider<League>(leagueService), 10)
      {
         @Override
         protected void executeOnClick(AjaxRequestTarget target, IModel<League> model)
         {
            PageParameters parameters = new PageParameters();
            parameters.set(SELECTED_LEAGUE_ID_KEY, model.getObject().getId());
            setResponsePage(LeagueDetailsPage.class, parameters);
         }
      });
   }
}