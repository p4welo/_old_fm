package com.football.manager.admin.pages;

import com.football.manager.admin.api.AdminApiMappings;
import com.football.manager.admin.pages.cmp.menu.MenuPanel;
import org.apache.wicket.markup.html.WebPage;

import java.io.Serializable;

/**
 * User: pawel.radomski
 * Date: 25.01.13
 * Time: 16:42
 */
public abstract class AbstractPage extends WebPage implements AdminApiMappings, Serializable
{
   protected AbstractPage()
   {
      add(new MenuPanel("menu"));
   }
}
