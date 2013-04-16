package com.fm.admin.api;

/**
 * User: pawel.radomski
 * Date: 25.01.13
 * Time: 16:43
 */
public interface AdminApiMappings extends AdminApiKeys
{
   public static final String INDEX_PAGE = "/index";

   public static final String LEAGUE_LIST_PAGE = "/admin/leagues";

   public static final String LEAGUE_DETAILS_PAGE = "/admin/league/${" + SELECTED_LEAGUE_SID_KEY + "}/details";

   public static final String GAME_CONFIG_PAGE = "/admin/game/config";

   public static final String MANAGER_LIST_PAGE = "/admin/managers";

   public static final String MANAGER_DETAILS_PAGE = "/admin/manager/${" + SELECTED_MANAGER_SID_KEY + "}/details";
}
