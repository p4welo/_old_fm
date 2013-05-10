package com.fm.service;

import javax.mail.MessagingException;

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

   void testSend();
}
