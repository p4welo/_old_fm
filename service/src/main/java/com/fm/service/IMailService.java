package com.fm.service;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

/**
 * User: pawel.radomski
 * Date: 16.04.13
 * Time: 14:04
 */
public interface IMailService
{
   public static final String MAIL_SERVER_USERNAME = "mail.server.username";

   void sendMail(String from, String to, String subject, String body);

   void sendMail(String from, String to, String cc, String subject, String body);

   void sendMail(String from, String[] to, String[] cc, String replyTo, String subject, String content);

   void sendHtmlMail(String from, String to, String subject, String body) throws MessagingException;

   void sendHtmlMail(String from, String to, String cc, String subject, String body) throws MessagingException;

   void sendHtmlMail(String from, String[] to, String[] cc, String replyTo, String subject, String content)
           throws MessagingException;
}
