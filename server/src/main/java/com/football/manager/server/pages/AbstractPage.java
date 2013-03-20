package com.football.manager.server.pages;

import com.football.manager.server.api.AdminApiMappings;
import com.football.manager.server.cmp.menu.MenuPanel;
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
