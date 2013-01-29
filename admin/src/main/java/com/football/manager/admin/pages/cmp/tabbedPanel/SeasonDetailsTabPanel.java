package com.football.manager.admin.pages.cmp.tabbedPanel;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * User: pawel
 * Date: 28.01.13
 * Time: 21:47
 */
public class SeasonDetailsTabPanel extends Panel
{
   private final WebMarkupContainer mainContainer;

   private final WebMarkupContainer leftContainer;

   private final WebMarkupContainer rightContainer;

   public SeasonDetailsTabPanel(String id)
   {
      super(id);
      setOutputMarkupId(true);

      mainContainer = new WebMarkupContainer("mainContainer");
      mainContainer.setOutputMarkupId(true);
      leftContainer = new WebMarkupContainer("leftContainer");
      leftContainer.setOutputMarkupId(true);
      rightContainer = new WebMarkupContainer("rightContainer");
      rightContainer.setOutputMarkupId(true);

      initView();
   }

   private void initView()
   {
      //To change body of created methods use File | Settings | File Templates.
   }
}
