package com.fm.admin.pages.leagueDetailsPage.cmp.chart;

import com.fm.domain.Season;
import com.fm.domain.Team;
import com.fm.domain.TeamRecord;
import com.fm.domain.defined.SystemParameters;
import com.fm.service.ISystemParameterService;
import com.fm.service.ITeamRecordService;
import com.googlecode.wickedcharts.highcharts.options.*;
import com.googlecode.wickedcharts.highcharts.options.series.SimpleSeries;
import com.googlecode.wickedcharts.wicket6.highcharts.Chart;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 24.04.13
 * Time: 22:16
 * To change this template use File | Settings | File Templates.
 */
public class ChartPanel extends Panel
{
   @SpringBean
   private ITeamRecordService teamRecordService;

   @SpringBean
   private ISystemParameterService systemParameterService;

   private List<TeamRecord> records;

   private final PropertyModel<Team> selectedModel;

   private final Season season;

   private Chart chart;

   public ChartPanel(String id, PropertyModel<Team> selectedModel, Season season)
   {
      super(id);
      this.selectedModel = selectedModel;
      this.season = season;
      setOutputMarkupId(true);
      initView();
   }

   @Override
   protected void onBeforeRender()
   {
      Team team = selectedModel.getObject();
      if (team != null)
      {
         records = teamRecordService.findAllTeamRecordsFromSeason(team, season);
         Options options = prepareOptionsForChart(records);
         chart.setOptions(options);
      }
      super.onBeforeRender();
   }

   private Options prepareOptionsForChart(List<TeamRecord> records)
   {
      Options options = new Options();
      options.setChartOptions(new ChartOptions().setType(SeriesType.LINE));

      options.setExporting(new ExportingOptions().setEnabled(false));

      List<String> xCategoryList = new ArrayList<String>();
      List<String> yCategoryList = new ArrayList<String>();
      List<Number> series = new ArrayList<Number>();
      for (int i = 0; i < records.size(); i++)
      {
         xCategoryList.add(String.valueOf(i + 1));
         series.add(records.get(i).getPlace());
      }

      int teamCount = Integer.valueOf(systemParameterService.getByKey(SystemParameters.TEAM_COUNT_PER_LEAGUE));
      for (int i = teamCount; i > 0; i--)
      {
         yCategoryList.add(String.valueOf(i));
      }
      options.setxAxis(new Axis().setCategories(xCategoryList));
      options.setyAxis(new Axis().setReversed(true).setMax(16).setMin(1).setAllowDecimals(false)
              .setTitle(new Title(getString("position"))));
      options.setTitle(new Title(getString("chart.title")));
      options.setLegend(new Legend().setLayout(LegendLayout.VERTICAL)
              .setAlign(HorizontalAlignment.CENTER)
              .setVerticalAlign(VerticalAlignment.BOTTOM)
              .setX(-10)
              .setY(100)
              .setBorderWidth(0));
      options.addSeries(new SimpleSeries().setName(getString("seriesName")).setData(series));
      return options;
   }

   private void initView()
   {
      chart = new Chart("chart", new Options().setChartOptions(new ChartOptions()))
      {
         @Override
         protected void onConfigure()
         {
            setVisible(selectedModel.getObject() != null);
         }
      };
      add(chart);
   }
}
