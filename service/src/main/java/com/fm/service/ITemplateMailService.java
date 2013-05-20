package com.fm.service;

import com.fm.domain.User;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 20.05.13
 * Time: 23:40
 * To change this template use File | Settings | File Templates.
 */
public interface ITemplateMailService
{
   void sendAccountActivationMail(User user);
}
