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

import java.util.ArrayList;
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
            int areaCount = positionAreaService.countAreasByPosition(position);
            if (selectedPosition != null && StringUtils.equals(selectedPosition.getSid(), position.getSid()))
            {
               item.add(AttributeModifier.append("class", "selectedRow"));
            }
            item.add(new Label("name", new PropertyModel(position, Position.FIELD_FULL_NAME)));
            item.add(new Label("shortName", new PropertyModel(position, Position.FIELD_SHORT_NAME)));
            item.add(new Label("areaCount", areaCount));
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
            boolean selected;

            @Override
            protected void onConfigure()
            {
               selected = false;
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
               if (selected)
               {
                  add(AttributeModifier.replace("class", "selected-position"));
               }
               else
               {
                  add(AttributeModifier.replace("class", "unselected-position"));
               }
            }

            @Override
            public void onClick(AjaxRequestTarget target)
            {
               if (selectedPosition != null)
               {
                  if (selected)
                  {
                     removePositionArea(selectedPosition, finalI);
                  }
                  else
                  {
                     addPositionArea(selectedPosition, finalI);
                  }
               }
               else
               {
                  error(getString("no.position.selected"));
               }
               target.add(PositionTab.this);
            }
         });
      }
   }

   public void addPositionArea(Position position, int area)
   {
      List<Integer> list = areas.get(position);
      if (list == null)
      {
         list = new ArrayList<Integer>();
      }
      list.add(area);
      areas.put(position, list);

      positionAreaService.addPositionArea(position, area);
      success(getString("position.updated.successfully"));
   }

   public void removePositionArea(Position position, int area)
   {
      List<Integer> list = areas.get(position);
      if (!CollectionUtils.isEmpty(list))
      {
         for (int i = 0; i < list.size(); i++)
         {
            if (list.get(i) == area)
            {
               list.remove(i);
            }
         }
      }
      else
      {
         list = new ArrayList<Integer>();
      }
      areas.put(position, list);

      positionAreaService.removePositionArea(position, area);
      success(getString("position.updated.successfully"));
   }
}
