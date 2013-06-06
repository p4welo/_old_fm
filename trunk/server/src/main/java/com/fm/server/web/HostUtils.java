package com.fm.server.web;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public class HostUtils
{
   private static final String DEFAULT_HTTP_PORT = "80";

   private static final String DEFAULT_HTTPS_PORT = "443";

   public static final String HTTP = "http";

   public static final String HTTPS = "https";

   public static final String STR1 = "://";

   public static final String STR2 = ":";

   public static final String DEFAULT_SERVER = "www.football-manager.com.pl";

   public static String buildServerEndPoint(ServletRequest request)
   {
      if (request == null || !(request instanceof HttpServletRequest))
      {
         return null;
      }
      HttpServletRequest httpRequest = (HttpServletRequest) request;

      StringBuilder sb = new StringBuilder();
      String scheme = httpRequest.getHeader(HttpHeaders.X_FORWARDED_SCHEME);
      String server = httpRequest.getHeader(HttpHeaders.X_FORWARDED_SERVER);
      String port = httpRequest.getHeader(HttpHeaders.X_FORWARDED_PORT);

      if (StringUtils.isNotBlank(scheme))
      {
         sb.append(scheme);
      }
      else
      {
         scheme = request.getScheme();
         sb.append(scheme);
      }
      sb.append(STR1);

      String resultServer;
      if (StringUtils.isNotBlank(server))
      {
         resultServer = server;
      }
      else
      {
         resultServer = request.getServerName();
      }

      String resultPort = new String();
      if (StringUtils.isNotBlank(port))
      {
         if (HTTP.equals(scheme))
         {
            if (!DEFAULT_HTTP_PORT.equals(port))
            {
               resultPort = STR2 + port;
            }
         }
         else
         {
            if (!DEFAULT_HTTPS_PORT.equals(port))
            {
               resultPort = STR2 + port;
            }
         }
      }
      else
      {
         resultPort = STR2 + request.getServerPort();
      }

      if (StringUtils.isNotBlank(resultPort))
      {
         resultServer = DEFAULT_SERVER;
      }

      sb.append(resultServer);
      sb.append(resultPort);

      sb.append(httpRequest.getContextPath());
      return sb.toString();
   }
}
