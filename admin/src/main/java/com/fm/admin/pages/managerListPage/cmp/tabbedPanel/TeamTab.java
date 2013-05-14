package com.fm.admin.pages.managerListPage.cmp.tabbedPanel;

import com.fm.domain.Manager;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * User: pawel
 * Date: 29.04.13
 * Time: 19:52
 */
public class TeamTab extends Panel
{
   public TeamTab(String id, IModel<Manager> model)
   {
      super(id, model);
   }
}
