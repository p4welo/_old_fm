package com.fm.server.web;

import com.fm.context.ServerEndpointHolder;

import javax.servlet.*;
import java.io.IOException;

public class ServerEndpointFilter implements Filter
{
   @Override
   public void init(FilterConfig filterConfig) throws ServletException
   {
   }

   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
           throws IOException, ServletException
   {
      try
      {
         ServerEndpointHolder.setEndpoint(HostUtils.buildServerEndPoint(request));
         chain.doFilter(request, response);
      }
      finally
      {
         ServerEndpointHolder.clearEndpoint();
      }
   }

   @Override
   public void destroy()
   {
   }
}
