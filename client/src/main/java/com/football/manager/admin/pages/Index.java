package com.football.manager.admin.pages;

import com.football.manager.admin.api.ClientApiMappings;
import com.football.manager.domain.Position;
import com.football.manager.service.IPositionService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

import java.util.List;

/**
 * User: pawel
 * Date: 12.01.13
 * Time: 13:02
 */
@MountPath(ClientApiMappings.INDEX_PAGE)
public class Index extends AbstractPage
{
   @SpringBean
   private IPositionService positionService;

   public Index()
   {
      List<Position> positionList = positionService.findAll();
      ListView listView = new ListView<Position>("list", positionList)
      {
         @Override
         protected void populateItem(ListItem<Position> components)
         {
            Position position = components.getModelObject();
            components.add(new Label("name", position.getShortName()));
            components.add(new Label("fullName", position.getFullName()));
         }
      };
      add(listView);
   }
}
