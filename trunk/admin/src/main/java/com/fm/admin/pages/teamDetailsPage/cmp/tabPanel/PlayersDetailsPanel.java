package com.fm.admin.pages.teamDetailsPage.cmp.tabPanel;

import com.fm.domain.Player;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 15.05.13
 * Time: 22:16
 * To change this template use File | Settings | File Templates.
 */
public class PlayersDetailsPanel extends Panel
{
   public PlayersDetailsPanel(String id, IModel<Player> model)
   {
      super(id, model);
   }

   @Override
   protected void onConfigure()
   {
      super.onConfigure();
      setVisible(getDefaultModelObject() != null);
   }
}
