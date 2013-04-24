package com.fm.admin.cmp.leagueSeasonsPage.chart;

import com.googlecode.wickedcharts.highcharts.options.*;
import com.googlecode.wickedcharts.highcharts.options.series.SimpleSeries;
import com.googlecode.wickedcharts.wicket6.highcharts.Chart;
import org.apache.wicket.markup.html.panel.Panel;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 24.04.13
 * Time: 22:16
 * To change this template use File | Settings | File Templates.
 */
public class ChartPanel extends Panel
{
   public ChartPanel(String id)
   {
      super(id);
      setOutputMarkupId(true);
      initView();
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
      add(new Chart("chart", options));
   }
}
