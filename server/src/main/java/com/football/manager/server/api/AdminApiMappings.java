package com.football.manager.server.api;

/**
 * User: pawel.radomski
 * Date: 25.01.13
 * Time: 16:43
 */
public interface AdminApiMappings extends AdminApiKeys
{
   public static final String INDEX_PAGE = "/index";

   public static final String LEAGUE_LIST_PAGE = "/league/list";

   public static final String LEAGUE_DETAILS_PAGE = "/league/${" + SELECTED_LEAGUE_ID_KEY + "}";
}
