package com.fm.service.importer;

import com.fm.domain.Surname;
import com.fm.service.ISurnameService;
import com.fm.service.impl.SurnameServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 13.04.13
 * Time: 11:00
 * To change this template use File | Settings | File Templates.
 */
public class SurnameImport
{
   public static void main(String[] args)
   {
      ApplicationContext context = new ClassPathXmlApplicationContext(
              "classpath:/spring/service-configuration-context.xml",
              "classpath:/spring/dao-context.xml",
              "classpath:/spring/service-context.xml");

      ISurnameService surnameService = (ISurnameService) context.getBean(SurnameServiceImpl.BEAN_NAME);

      URL url = SurnameImport.class.getResource("/importer/surnames.txt");
      if (url != null)
      {
         try
         {
            BufferedReader surnameFile = new BufferedReader(new FileReader(url.getFile()));
            String line;
            while ((line = surnameFile.readLine()) != null)
            {
               Surname surname = new Surname();
               surname.setValue(line);
               surnameService.save(surname);
            }
            surnameFile.close();
         }
         catch (FileNotFoundException e)
         {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
         }
         catch (IOException e)
         {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
         }
      }
   }
}
