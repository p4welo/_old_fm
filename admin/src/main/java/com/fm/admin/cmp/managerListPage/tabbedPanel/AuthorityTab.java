package com.fm.admin.cmp.managerListPage.tabbedPanel;

import com.fm.domain.Manager;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * User: pawel
 * Date: 29.04.13
 * Time: 19:53
 */
public class AuthorityTab extends Panel
{
   public AuthorityTab(String id, IModel<Manager> model)
   {
      super(id, model);
   }
}
