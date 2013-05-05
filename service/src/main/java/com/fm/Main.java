package com.fm;

import java.util.Random;

/**
 * User: pawel
 * Date: 14.01.13
 * Time: 20:33
 */
public class Main
{
   public static int getPotential(int age)
   {
      int value;
      double m = (3500 - 100 * age) / 17.0;
      int s = 13;

      Random r = new Random();
      do
      {
         double val = r.nextGaussian() * s + m;
         value = (int) Math.round(val);
      }
      while (value < 0 || value > 100);
      return value;
   }

   public static void main(String[] args) throws Exception
   {
      for (int i = 0; i < 20; i++)
      {
         System.out.println("" + getPotential(35));
      }

//      ApplicationContext context = new ClassPathXmlApplicationContext(
//              "classpath:/spring/service-configuration-context.xml",
//              "classpath:/spring/dao-context.xml",
//              "classpath:/spring/service-context.xml");
//
//      PlayerServiceImpl playerService = (PlayerServiceImpl) context
//              .getBean(PlayerServiceImpl.BEAN_NAME);
//
//      Player player = new Player();
//      player.setBirth(new Date());
//      player.setName("Pawel");
//      player.setSurname("Radomski");

//      playerService.save(player);
   }
}
