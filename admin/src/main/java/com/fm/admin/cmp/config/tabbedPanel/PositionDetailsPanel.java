package com.fm.admin.cmp.config.tabbedPanel;

import com.fm.core.cmp.masterDetail.DetailsPanel;
import com.fm.domain.Position;
import com.fm.service.IPositionAreaService;
import com.fm.service.IPositionService;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 18.04.13
 * Time: 20:34
 * To change this template use File | Settings | File Templates.
 */
public class PositionDetailsPanel extends DetailsPanel<Position>
{
   @SpringBean
   private IPositionAreaService positionAreaService;

   @SpringBean
   private IPositionService positionService;

   private List<Position> positions;

   private Map<Position, List<Integer>> areas;

   private PositionTab positionTab;

   public PositionDetailsPanel(String id, IModel<Position> model, PositionTab positionTab)
   {
      super(id, model);
      this.positionTab = positionTab;
      initView();
      positions = positionService.findAll();
      areas = positionAreaService.findAllByPositions(positions);
   }

   @Override
   protected void onConfigure()
   {
   }

   @Override
   protected void onBeforeRender()
   {
      areas = positionAreaService.findAllByPositions(positions);
      super.onBeforeRender();
   }

   private void initView()
   {
      for (int i = 0; i < 27; i++)
      {
         final int finalI = i;
         add(new AjaxLink<Void>("area" + finalI)
         {
            boolean isSelected;

            @Override
            protected void onConfigure()
            {
               isSelected = false;
               Position position = getSelected();
               if (position != null)
               {
                  List<Integer> list = new ArrayList<Integer>();
                  Set<Position> keys = areas.keySet();
                  for (Position key : keys)
                  {
                     if (key.equals(position))
                     {
                        list = areas.get(key);
                     }
                  }
                  if (!CollectionUtils.isEmpty(list))
                  {
                     for (int j : list)
                     {
                        if (j == finalI)
                        {
                           isSelected = true;
                        }
                     }
                  }
               }
               if (isSelected)
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
               if (getSelected() != null)
               {
                  if (isSelected)
                  {
                     removePositionArea(getSelected(), finalI);
                  }
                  else
                  {
                     addPositionArea(getSelected(), finalI);
                  }
               }
               else
               {
                  error(getString("no.position.selected"));
               }
               target.add(positionTab);
            }
         });
      }
   }

   public void addPositionArea(Position position, int area)
   {
//      List<Integer> list = areas.get(position);
//      if (list == null)
//      {
//         list = new ArrayList<Integer>();
//      }
//      list.add(area);
//      areas.put(position, list);

      positionAreaService.addPositionArea(position, area);
      success(getString("position.updated.successfully"));
   }

   public void removePositionArea(Position position, int area)
   {
//      List<Integer> list = areas.get(position);
//      if (!CollectionUtils.isEmpty(list))
//      {
//         for (int i = 0; i < list.size(); i++)
//         {
//            if (list.get(i) == area)
//            {
//               list.remove(i);
//            }
//         }
//      }
//      else
//      {
//         list = new ArrayList<Integer>();
//      }
//      areas.put(position, list);

      positionAreaService.removePositionArea(position, area);
      success(getString("position.updated.successfully"));
   }
}
