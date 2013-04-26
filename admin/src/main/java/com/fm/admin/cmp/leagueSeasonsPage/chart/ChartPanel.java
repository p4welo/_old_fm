package com.fm.admin.cmp.leagueSeasonsPage.chart;

import com.fm.domain.Season;
import com.fm.domain.Team;
import com.fm.domain.TeamRecord;
import com.fm.service.ITeamRecordService;
import com.googlecode.wickedcharts.highcharts.options.*;
import com.googlecode.wickedcharts.highcharts.options.series.SimpleSeries;
import com.googlecode.wickedcharts.wicket6.highcharts.Chart;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.ArrayList;
import java.util.Arrays;
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

      List<String> xCategoryList = new ArrayList<String>();
      List<String> yCategoryList = new ArrayList<String>();
      List<Number> series = new ArrayList<Number>();
      for (int i = 0; i < records.size(); i++)
      {
         xCategoryList.add(String.valueOf(i + 1));
         series.add(records.get(i).getPlace());
      }
      for (int i = 17; i > 0; i--)
      {
         yCategoryList.add(String.valueOf(i));
      }
      options.setxAxis(new Axis().setCategories(xCategoryList));
      options.setyAxis(new Axis().setMax(16).setMin(1).setTitle(new Title("Miejsce")));
      options.setLegend(new Legend().setLayout(LegendLayout.VERTICAL)
              .setAlign(HorizontalAlignment.CENTER)
              .setVerticalAlign(VerticalAlignment.BOTTOM)
              .setX(-10)
              .setY(100)
              .setBorderWidth(0));
      options.addSeries(new SimpleSeries().setName("Tokyo").setData(series));
      return options;
   }

   private void initView()
   {
      Options options = new Options();

      options.setChartOptions(new ChartOptions()
              .setType(SeriesType.COLUMN));

      options.setTitle(new Title("My very own chart."));

      options.setxAxis(new Axis().setCategories(Arrays.asList(new String[]{"1", "2", "3", "4", "5",
              "6", "7", "8", "9", "10", "11", "12"})));

      options.setyAxis(new Axis().setTitle(new Title("Miejsce")));

      options.setLegend(new Legend().setLayout(LegendLayout.VERTICAL)
              .setAlign(HorizontalAlignment.CENTER)
              .setVerticalAlign(VerticalAlignment.BOTTOM)
              .setX(-10)
              .setY(100)
              .setBorderWidth(0));

      options.addSeries(new SimpleSeries().setName("Tokyo").setData(
              Arrays.asList(new Number[]{7.0, 6.9, 9.5, 14.5, 18.2, 21.5,
                      25.2, 26.5, 23.3, 18.3, 13.9, 9.6})));
      chart = new Chart("chart", options);
      add(chart);
   }
}
