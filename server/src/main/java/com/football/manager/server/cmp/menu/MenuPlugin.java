package com.football.manager.server.cmp.menu;

import com.football.manager.server.AdminApplication;
import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;

import java.util.ArrayList;
import java.util.List;

/**
 * User: pawel
 * Date: 26.01.13
 * Time: 10:51
 */
public class MenuPlugin extends Panel
{
   private List<MenuItem> menuItemList = new ArrayList<MenuItem>();

   private static String selectedItem;

   public MenuPlugin(String id)
   {
      super(id);

      add(new Link("homeLink")
      {
         @Override
         public void onClick()
         {
            setResponsePage(AdminApplication.get().getHomePage());
         }
      });

      ListView listview = new ListView("menuItem", menuItemList)
      {
         private static final long serialVersionUID = -7597884223556472130L;

         @Override
         protected void onBeforeRender()
         {
            for (MenuItem menuItem : MenuPlugin.this.menuItemList)
            {
               if (getPage().getClass() == menuItem.getTarget())
               {
                  selectedItem = menuItem.getTarget().toString();
               }
            }
            super.onBeforeRender();
         }

         protected void populateItem(ListItem item)
         {
            final MenuItem menuItem = (MenuItem) item.getModelObject();

            Link link = new Link("link")
            {
               @Override
               public void onClick()
               {
                  setResponsePage(menuItem.getTarget());
               }
            };

            if (menuItem.getTarget().toString().equals(selectedItem))
            {
               item.add(new AttributeModifier("class", new Model("active")));
            }

            Label label = new Label("label", new ResourceModel(menuItem.getResourceKey()));
            MarkupContainer container = link.add(label);
            item.add(container);
         }
      };
      add(listview);
   }

   public void add(String label, Class<? extends WebPage> target)
   {
      MenuItem menuItem = new MenuItem(label, target);
      menuItemList.add(menuItem);
      if (StringUtils.isBlank(selectedItem))
      {
         selectedItem = menuItem.getTarget().toString();
      }
   }

   public List<Class> getTargetClasses()
   {
      List<Class> targetClasses = new ArrayList<Class>();
      for (MenuItem menuItem : menuItemList)
      {
         targetClasses.add(menuItem.getTarget());
      }

      return targetClasses;
   }
}
