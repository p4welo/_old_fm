package com.fm.admin.pages;

import com.fm.admin.api.AdminApiMappings;
import com.fm.admin.cmp.menu.AdminMenuPanel;
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
      add(new AdminMenuPanel("menu"));
   }
}
