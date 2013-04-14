package com.fm.admin.cmp.config.tabbedPanel;

import com.fm.core.cmp.feedback.NotifyFeedbackPanel;
import com.fm.domain.Position;
import com.fm.service.IPositionAreaService;
import com.fm.service.IPositionService;
import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

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

   @SpringBean
   private IPositionAreaService positionAreaService;

   private List<Position> positions;

   private Position hoveredPosition;

   private Position selectedPosition;

   private Map<Position, List<Integer>> areas;

   public PositionTab(String id)
   {
      super(id);
      setOutputMarkupId(true);
      positions = positionService.findAll();
      areas = positionAreaService.findAllByPositions(positions);

      initView();
   }

   private void initView()
   {
      add(new NotifyFeedbackPanel("feedback"));
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
            final Position position = item.getModelObject();
            if (selectedPosition != null && StringUtils.equals(selectedPosition.getSid(), position.getSid()))
            {
               item.add(AttributeModifier.append("class", "selectedRow"));
            }
            item.add(new Label("name", new PropertyModel(position, Position.FIELD_FULL_NAME)));
            item.add(new Label("shortName", new PropertyModel(position, Position.FIELD_SHORT_NAME)));
//            item.add(new AjaxEventBehavior("mouseover")
//            {
//               @Override
//               protected void onEvent(AjaxRequestTarget target)
//               {
//                  hoveredPosition = position;
//                  target.add(PositionTab.this);
//               }
//            });
//            item.add(new AjaxEventBehavior("mouseout")
//            {
//               @Override
//               protected void onEvent(AjaxRequestTarget target)
//               {
//                  hoveredPosition = null;
//                  target.add(PositionTab.this);
//               }
//            });
            item.add(new AjaxEventBehavior("onclick")
            {
               @Override
               protected void onEvent(AjaxRequestTarget target)
               {
                  selectedPosition = position;
                  target.add(PositionTab.this);
               }
            });
         }
      });
      for (int i = 0; i < 27; i++)
      {
         final int finalI = i;
         add(new AjaxLink<Void>("area" + finalI)
         {
            @Override
            protected void onConfigure()
            {
               boolean selected = false;
               if (selectedPosition != null)
               {
                  List<Integer> list = areas.get(selectedPosition);
                  if (!CollectionUtils.isEmpty(list))
                  {
                     for (int j : list)
                     {
                        if (j == finalI)
                        {
                           selected = true;
                        }
                     }
                  }
               }
//               setVisible(visible);
               if (selected)
               {
                  add(AttributeModifier.replace("class", "selectedRow"));
               }
               else
               {
                  add(AttributeModifier.replace("class", "unselectedRow"));
               }
            }

            @Override
            public void onClick(AjaxRequestTarget target)
            {
            }
         });
      }
   }
}
