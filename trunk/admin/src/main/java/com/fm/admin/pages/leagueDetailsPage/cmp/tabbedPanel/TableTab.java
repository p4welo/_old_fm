package com.fm.admin.pages.leagueDetailsPage.cmp.tabbedPanel;

import com.fm.admin.navigation.NavigateToTeamDetailsPage;
import com.fm.admin.pages.leagueDetailsPage.cmp.chart.ChartPanel;
import com.fm.core.ajax.ConfirmationCallListener;
import com.fm.core.cmp.masterDetail.EmptyDetailsPanel;
import com.fm.core.cmp.notify.Notification;
import com.fm.domain.League;
import com.fm.domain.Season;
import com.fm.domain.TeamRecord;
import com.fm.service.ISeasonService;
import com.fm.service.ITeamRecordService;
import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.AjaxLazyLoadPanel;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.util.value.IValueMap;

import java.util.List;

/**
 * User: pawel.radomski
 * Date: 19.04.13
 * Time: 16:47
 */
public class TableTab extends Panel
{
   @SpringBean
   private ISeasonService seasonService;

   @SpringBean
   private ITeamRecordService teamRecordService;

   private Season season;

   private List<Season> seasonList;

   private List<TeamRecord> teamRecords;

   private ChartPanel chart;

   private String selectedTeamSid;

   public TableTab(String id, IModel<League> model)
   {
      super(id, model);
      setOutputMarkupId(true);
      League league = model.getObject();
      seasonList = seasonService.getLeagueSeasons((League) getDefaultModelObject());
      season = seasonService.getActiveSeason(league);
      teamRecords = teamRecordService.findTeamRecordsBySeason(season, true);
   }

   @Override
   protected void onInitialize()
   {
      super.onInitialize();
      provideListSection();
      provideToolbarSection();
      provideChartSection();
   }

   private void provideChartSection()
   {
      add(new EmptyDetailsPanel<String>("empty", new PropertyModel(this, "selectedTeamSid")));
      add(new AjaxLazyLoadPanel("chartPanel")
      {
         @Override
         public Component getLazyLoadComponent(String id)
         {
            chart = new ChartPanel(id, new PropertyModel<String>(TableTab.this, "selectedTeamSid"),
                    new PropertyModel<Season>(TableTab.this, "season"));
            chart.setOutputMarkupId(true);
            return chart;
         }
      });
   }

   private void provideListSection()
   {
      final ListView<TeamRecord> teamListView = new ListView<TeamRecord>("teams",
              new PropertyModel<List<? extends TeamRecord>>(this, "teamRecords"))
      {
         @Override
         protected void onConfigure()
         {
            teamRecords = teamRecordService.findTeamRecordsBySeason(season, true);
            super.onConfigure();
         }

         @Override
         protected void populateItem(final ListItem<TeamRecord> item)
         {
            final TeamRecord teamRecord = item.getModelObject();
            item.add(new Label("place", new PropertyModel<String>(teamRecord, TeamRecord.FIELD_PLACE)));
            item.add(new Label("name", new PropertyModel<String>(teamRecord, TeamRecord.FIELD_TEAM_NAME)));
            item.add(new Label("round", new PropertyModel<String>(teamRecord, TeamRecord.FIELD_ROUND_NUMBER)));
            item.add(new Label("points", new PropertyModel<String>(teamRecord, TeamRecord.FIELD_POINTS_COUNT)));
            item.add(new Label("goalsScored", new PropertyModel<String>(teamRecord, TeamRecord.FIELD_GOALS_SCORED)));
            item.add(new Label("goalsAllowed", new PropertyModel<String>(teamRecord, TeamRecord.FIELD_GOALS_ALLOWED)));
            item.add(new Label("goalsDifference",
                    new PropertyModel<String>(teamRecord, TeamRecord.FIELD_GOALS_DIFFERENCE)));
            item.add(new Label("wins", new PropertyModel<String>(teamRecord, TeamRecord.FIELD_WINS_COUNT)));
            item.add(new Label("draws", new PropertyModel<String>(teamRecord, TeamRecord.FIELD_DRAWS_COUNT)));
            item.add(new Label("loses", new PropertyModel<String>(teamRecord, TeamRecord.FIELD_LOSES_COUNT)));
            item.add(new AjaxEventBehavior("onclick")
            {
               @Override
               protected void onEvent(AjaxRequestTarget target)
               {
                  executeOnClick(target, item.getModel());
               }
            });
            if (StringUtils.equals(teamRecord.getTeamSid(), selectedTeamSid))
            {
               item.add(AttributeModifier.append("class", "selectedElement"));
            }
         }
      };
      add(teamListView);
   }

   private void provideToolbarSection()
   {
      add(new AjaxLink<Void>("newSeason")
      {
         @Override
         public void onClick(AjaxRequestTarget target)
         {
            season = seasonService.nextSeason((League) TableTab.this.getDefaultModelObject());
            Notification.success(getString("next.season.successfully.generated"));
            target.add(TableTab.this);
         }
      });

      add(new AjaxLink<Void>("nextRound")
      {
         @Override
         public void onClick(AjaxRequestTarget target)
         {
            teamRecords = teamRecordService.simulateNextRound(season);
            target.add(TableTab.this);
         }

         @Override
         protected void onConfigure()
         {
            setVisible(season != null);
         }

         @Override
         protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
         {
            super.updateAjaxAttributes(attributes);
            attributes.getAjaxCallListeners().add(new ConfirmationCallListener(getString("next.round.confirm")));
         }
      });
      add(new AjaxLink<Void>("teamDetails")
      {
         @Override
         protected void onConfigure()
         {
            setEnabled(selectedTeamSid != null);
            super.onConfigure();
         }

         @Override
         protected void onComponentTag(ComponentTag tag)
         {
            super.onComponentTag(tag);
            IValueMap attributes = tag.getAttributes();
            String clazz = attributes.getString("class");

            if (!isEnabled())
            {
               attributes.put("class", clazz + " disabled");
            }
            else
            {
               attributes.put("class", clazz);
            }
         }

         @Override
         public void onClick(AjaxRequestTarget target)
         {
            new NavigateToTeamDetailsPage(selectedTeamSid).navigate();
         }
      });
      DropDownChoice dropDownChoice = new DropDownChoice<Season>("season", new PropertyModel<Season>(this, "season"),
              seasonList, new IChoiceRenderer<Season>()
      {
         @Override
         public Object getDisplayValue(Season object)
         {
            return object.getNumber();
         }

         @Override
         public String getIdValue(Season object, int index)
         {
            return object.getSid();
         }
      });
      dropDownChoice.add(new OnChangeAjaxBehavior()
      {
         @Override
         protected void onUpdate(AjaxRequestTarget target)
         {
            target.add(TableTab.this);
         }
      });
      add(dropDownChoice);
   }

   private void executeOnClick(AjaxRequestTarget target, IModel<TeamRecord> model)
   {
      selectedTeamSid = model.getObject().getTeamSid();
      target.add(TableTab.this);
   }
}