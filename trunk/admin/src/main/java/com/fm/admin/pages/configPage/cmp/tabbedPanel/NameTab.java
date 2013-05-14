package com.fm.admin.pages.configPage.cmp.tabbedPanel;

import com.fm.admin.pages.configPage.cmp.masterDetail.NameMasterDetail;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 13.04.13
 * Time: 11:17
 * To change this template use File | Settings | File Templates.
 */
public class NameTab extends Panel
{
   public NameTab(String id)
   {
      super(id);
//      setOutputMarkupId(true);
//      add(new AjaxLink<Void>("load")
//      {
//         @Override
//         public void onClick(AjaxRequestTarget target)
//         {
//            NameImport.main(null);
//            target.add(NameTab.this);
//         }
//      });
      add(new NameMasterDetail("masterDetail"));
   }
}
