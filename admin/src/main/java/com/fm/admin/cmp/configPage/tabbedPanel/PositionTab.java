package com.fm.admin.cmp.configPage.tabbedPanel;

import com.fm.admin.cmp.configPage.masterDetail.PositionMasterDetail;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 13.04.13
 * Time: 11:17
 * To change this template use File | Settings | File Templates.
 */
public class PositionTab extends Panel
{
   public PositionTab(String id)
   {
      super(id);
      add(new PositionMasterDetail("masterDetail"));
   }
}
