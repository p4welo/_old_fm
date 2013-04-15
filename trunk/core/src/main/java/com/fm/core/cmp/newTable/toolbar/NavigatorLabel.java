package com.fm.core.cmp.newTable.toolbar;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.navigation.paging.IPageableItems;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.util.io.IClusterable;

public class NavigatorLabel extends Label
{
   private static final long serialVersionUID = 8060663421096966425L;

   public NavigatorLabel(final String id, final IPageableItems pageable)
   {
      super(id);
      setDefaultModel(new StringResourceModel("CustomNavigatorLabel", this, new Model<LabelModelObject>(
              new LabelModelObject(pageable))));
   }

   private static class LabelModelObject implements IClusterable
   {
      private static final long serialVersionUID = 1L;

      private final IPageableItems pageable;

      public LabelModelObject(final IPageableItems table)
      {
         pageable = table;
      }

      @SuppressWarnings("unused")
      public long getCurrentPage()
      {
         return pageable.getCurrentPage() + 1;
      }

      @SuppressWarnings("unused")
      public long getPageCount()
      {
         return pageable.getPageCount();
      }
   }
}
