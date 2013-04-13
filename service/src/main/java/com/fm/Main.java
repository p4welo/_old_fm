package com.fm;

import com.fm.domain.Player;
import com.fm.service.impl.PlayerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

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

      PlayerServiceImpl playerService = (PlayerServiceImpl) context
              .getBean(PlayerServiceImpl.BEAN_NAME);

      Player player = new Player();
      player.setBirth(new Date());
      player.setName("Pawel");
      player.setSurname("Radomski");

//      playerService.save(player);
   }
}
