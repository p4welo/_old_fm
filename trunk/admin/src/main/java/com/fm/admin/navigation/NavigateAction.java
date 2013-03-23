package com.fm.admin.navigation;

import org.apache.wicket.Page;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.io.Serializable;

/**
 * User: pawel.radomski
 * Date: 21.02.13
 * Time: 19:27
 */
public abstract class NavigateAction implements Serializable
{
   private final Class cls;

   public NavigateAction(Class<? extends Page> cls)
   {
      this.cls = cls;
   }

   public abstract PageParameters getPageParameters();

   public Class getCls()
   {
      return cls;
   }

   public void navigate()
   {
      RequestCycle.get().setResponsePage(cls, getPageParameters());
   }
}
