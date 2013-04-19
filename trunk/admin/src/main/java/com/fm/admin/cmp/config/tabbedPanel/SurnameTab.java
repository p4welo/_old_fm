package com.fm.admin.cmp.config.tabbedPanel;

import com.fm.admin.cmp.config.masterDetail.SurnameMasterDetail;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 15.04.13
 * Time: 22:52
 * To change this template use File | Settings | File Templates.
 */
public class SurnameTab extends Panel
{
   public SurnameTab(String id)
   {
      super(id);
      add(new SurnameMasterDetail("masterDetail"));
   }
}
