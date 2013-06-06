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
      if (StringUtils.isNotBlank(server))
      {
         sb.append(server);
      }
      else
      {
         sb.append(request.getServerName());
      }
      if (StringUtils.isNotBlank(port))
      {
         if (HTTP.equals(scheme))
         {
            if (!DEFAULT_HTTP_PORT.equals(port))
            {
               sb.append(STR2).append(port);
            }
         }
         else
         {
            if (!DEFAULT_HTTPS_PORT.equals(port))
            {
               sb.append(STR2).append(port);
            }
         }
      }
      else
      {
         sb.append(STR2).append(request.getServerPort());
      }

      sb.append(httpRequest.getContextPath());
      return sb.toString();
   }
}
