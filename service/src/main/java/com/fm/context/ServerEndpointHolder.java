package com.fm.context;

import org.springframework.util.Assert;

public class ServerEndpointHolder
{
   private static final ThreadLocal<String> HOLDER = new ThreadLocal<String>();

   private static final String DEFAULT_ENDPOINT = "http://localhost";

   public static void clearEndpoint()
   {
      HOLDER.set(null);
   }

   public static String getEndpoint()
   {
      String endpoint = HOLDER.get();

      if (endpoint == null)
      {
         endpoint = DEFAULT_ENDPOINT;
         HOLDER.set(endpoint);
      }

      return endpoint;
   }

   public static void setEndpoint(String endpoint)
   {
      Assert.notNull(endpoint, "Only non-null endpoint instances are permitted");
      HOLDER.set(endpoint);
   }
}
