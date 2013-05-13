package com.fm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: pawel
 * Date: 14.01.13
 * Time: 20:33
 */
public class Main
{
   public static void main(String[] args) throws Exception
   {
      ApplicationContext context = new ClassPathXmlApplicationContext(
              "classpath:/spring/service-configuration-context.xml",
              "classpath:/spring/dao-context.xml",
              "classpath:/spring/service-context.xml");

//      ITeamGenerationStrategy strategy = (ITeamGenerationStrategy) context.getBean("teamGenerationStrategy");
//
//      strategy.generatePlayers()

   }
}
