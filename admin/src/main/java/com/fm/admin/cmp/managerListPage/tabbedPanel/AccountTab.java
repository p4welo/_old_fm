package com.fm.admin.cmp.managerListPage.tabbedPanel;

import com.fm.domain.Manager;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * User: pawel
 * Date: 29.04.13
 * Time: 19:51
 */
public class AccountTab extends Panel
{
   public AccountTab(String id, IModel<Manager> model)
   {
      super(id, model);
   }
}
