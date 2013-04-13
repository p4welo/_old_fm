package com.fm.admin.cmp.config.tabbedPanel;

import com.fm.domain.Position;
import com.fm.service.IPositionService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 13.04.13
 * Time: 11:17
 * To change this template use File | Settings | File Templates.
 */
public class PositionTab extends Panel
{
   @SpringBean
   private IPositionService positionService;

   private List<Position> positions;

   public PositionTab(String id)
   {
      super(id);
      positions = positionService.findAll();

      initView();
   }

   private void initView()
   {
      add(new ListView<Position>("list", positions)
      {
         @Override
         protected void onBeforeRender()
         {
            positions = positionService.findAll();
            super.onBeforeRender();
         }

         @Override
         protected void populateItem(ListItem<Position> item)
         {
            Position position = item.getModelObject();
            item.add(new Label("name", new PropertyModel(position, Position.FIELD_FULL_NAME)));
         }
      });
   }
}
