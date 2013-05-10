package com.fm;

import com.fm.service.IMailService;
import com.fm.service.impl.MailServiceImpl;
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

//      INameService nameService = (INameService) context.getBean(NameServiceImpl.BEAN_NAME);
      IMailService mailService = (IMailService) context.getBean(MailServiceImpl.BEAN_NAME);
      mailService.testSend();
      int i = 5;

//      ISurnameService surnameService = (ISurnameService) context.getBean(SurnameServiceImpl.BEAN_NAME);
//      IPositionService positionService = (IPositionService) context.getBean(PositionServiceImpl.BEAN_NAME);
//      PlayerGenerationStrategy strategy = new PlayerGenerationStrategy();
//
//      for (int i = 0; i < 20; i++)
//      {
//         System.out.println(i + ": ======================================");
//         Player player = new Player();
//         player.setName(nameService.getRandom().toString());
//         player.setSurname(surnameService.getRandom().toString());
//
//         System.out.println(player.getName() + " " + player.getSurname());
//         int age = strategy.getAge();
//         System.out.println("Pozycja: " + positionService.getRandom().getFullName());
//         System.out.println("Wiek: " + age);
//         System.out.println("Potencjał: " + strategy.getPotential(age));
//
//      }

   }
}
