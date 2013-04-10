package com.fm.admin.navigation;

import com.fm.core.navigation.NavigateAction;
import org.apache.wicket.Page;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * User: pawel.radomski
 * Date: 10.04.13
 * Time: 17:56
 */
public class SimpleNavigateAction extends NavigateAction
{
   public SimpleNavigateAction(Class<? extends Page> cls)
   {
      super(cls);
   }

   @Override
   public PageParameters getPageParameters()
   {
      return new PageParameters();
   }
}
