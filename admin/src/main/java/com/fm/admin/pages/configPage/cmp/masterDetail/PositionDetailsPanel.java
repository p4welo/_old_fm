package com.fm.admin.pages.configPage.cmp.masterDetail;

import com.fm.core.cmp.masterDetail.DetailsPanel;
import com.fm.core.cmp.notify.Notification;
import com.fm.domain.Position;
import com.fm.service.IPositionAreaService;
import com.fm.service.IPositionService;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.util.CollectionUtils;

import java.util.List;

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

   private PositionMasterDetail masterDetail;

   public PositionDetailsPanel(String id, IModel<Position> model, PositionMasterDetail masterDetail)
   {
      super(id, model);
      this.masterDetail = masterDetail;
      initView();
      positions = positionService.findAll();
   }

   @Override
   protected void onConfigure()
   {
      setSelected((Position) getDefaultModelObject());
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
                  List<Integer> list = positionAreaService.findByPosition(position);

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
                     Notification.success(getString("position.updated.successfully"));
                  }
                  else
                  {
                     addPositionArea(getSelected(), finalI);
                     Notification.success(getString("position.updated.successfully"));
                  }
               }
               else
               {
                  Notification.error(getString("no.position.selected"));
               }
               target.add(PositionDetailsPanel.this);
            }
         });
      }
   }

   public void addPositionArea(Position position, int area)
   {
      positionAreaService.addPositionArea(position, area);
   }

   public void removePositionArea(Position position, int area)
   {
      positionAreaService.removePositionArea(position, area);
   }
}
