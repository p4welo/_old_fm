package com.fm.admin.pages.teamDetailsPage.cmp.tabPanel;

import com.fm.core.cmp.label.ColorValueLabel;
import com.fm.domain.Player;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 15.05.13
 * Time: 22:16
 * To change this template use File | Settings | File Templates.
 */
public class PlayersDetailsPanel extends Panel
{
   private Player player;

   public PlayersDetailsPanel(String id, IModel<Player> model)
   {
      super(id, model);
   }

   @Override
   protected void onInitialize()
   {
      super.onInitialize();
      add(new Label("name", PropertyModel.of(this, "player." + Player.FIELD_NAME)));
      add(new Label("surname", PropertyModel.of(this, "player." + Player.FIELD_SURNAME)));
      add(new Label("age", PropertyModel.of(this, "player." + Player.FIELD_AGE)));

      add(new ColorValueLabel("speed", PropertyModel.of(this, "player." + Player.FIELD_SPEED), 20));
      add(new ColorValueLabel("stamina", PropertyModel.of(this, "player." + Player.FIELD_STAMINA), 20));
      add(new ColorValueLabel("crossing", PropertyModel.of(this, "player." + Player.FIELD_CROSSING), 20));
      add(new ColorValueLabel("passing", PropertyModel.of(this, "player." + Player.FIELD_PASSING), 20));
   }

   @Override
   protected void onConfigure()
   {
      super.onConfigure();
      player = (Player) getDefaultModelObject();
      setVisible(player != null);
   }
}
