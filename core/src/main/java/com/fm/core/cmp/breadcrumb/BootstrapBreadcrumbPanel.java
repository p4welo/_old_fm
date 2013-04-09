package com.fm.core.cmp.breadcrumb;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 03.04.13
 * Time: 22:17
 * To change this template use File | Settings | File Templates.
 */
public abstract class BootstrapBreadcrumbPanel extends Panel
{
   protected List<BreadCrumbAction> linkList = new ArrayList<BreadCrumbAction>();

   protected IModel actualPositionModel;

   public BootstrapBreadcrumbPanel(String id)
   {
      super(id);
      setLinkList(provideLinkList());
      setActualPositionModel(provideActualLabelModel());
      initView();
   }

   private void initView()
   {
      ListView<BreadCrumbAction> breadCrumbList = new ListView<BreadCrumbAction>("list", linkList)
      {
         @Override
         protected void populateItem(ListItem<BreadCrumbAction> components)
         {
            final BreadCrumbAction action = components.getModelObject();
            AjaxLink link = new AjaxLink<Void>("link")
            {
               @Override
               public void onClick(AjaxRequestTarget target)
               {
                  action.getNavigateAction().navigate();
               }
            };
            link.add(new Label("label", action.getLabelModel()));
            components.add(link);
         }
      };
      add(breadCrumbList);
      add(new Label("actual", actualPositionModel));
   }

   public List<BreadCrumbAction> getLinkList()
   {
      return linkList;
   }

   public void setLinkList(List<BreadCrumbAction> linkList)
   {
      this.linkList = linkList;
   }

   public IModel getActualPositionModel()
   {
      return actualPositionModel;
   }

   public void setActualPositionModel(IModel actualPositionModel)
   {
      this.actualPositionModel = actualPositionModel;
   }

   public abstract List<BreadCrumbAction> provideLinkList();

   public abstract IModel provideActualLabelModel();

}
