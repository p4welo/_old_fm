package com.fm.user.api;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 02.06.13
 * Time: 17:37
 * To change this template use File | Settings | File Templates.
 */
public interface UserApiMappings extends UserApiKeys
{
   public static final String USER_ACTIVATION_PAGE = "/user/${" + USER_SID_KEY + "}/activation";
}
