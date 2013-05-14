package com.fm.admin.navigation;

import com.fm.admin.pages.configPage.ConfigPage;
import com.fm.core.navigation.NavigateAction;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * User: pawel.radomski
 * Date: 09.04.13
 * Time: 12:14
 */
public class TestNavigation extends NavigateAction
{
   public TestNavigation()
   {
      super(ConfigPage.class);
   }

   @Override
   public PageParameters getPageParameters()
   {
      return null;  //To change body of implemented methods use File | Settings | File Templates.
   }
}
