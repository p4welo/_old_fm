package com.football.manager.admin.cmp.tabbedPanel;

import org.apache.wicket.extensions.ajax.markup.html.tabs.AjaxTabbedPanel;

import java.util.List;

/**
 * User: pawel
 * Date: 07.02.13
 * Time: 20:00
 */
public class BootstrapTabbedPanel extends AjaxTabbedPanel
{
   private static final long serialVersionUID = 7508687462547405139L;

   public BootstrapTabbedPanel(String id, List tabs)
   {
      super(id, tabs);
   }

   @Override
   protected String getSelectedTabCssClass()
   {
      return "active";
   }
}