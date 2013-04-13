package com.fm.service.importer;

import com.fm.domain.Name;
import com.fm.service.INameService;
import com.fm.service.impl.NameServiceImpl;
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
 * Time: 10:28
 * To change this template use File | Settings | File Templates.
 */
public class NameImport
{
   public static void main(String[] args)
   {
      ApplicationContext context = new ClassPathXmlApplicationContext(
              "classpath:/spring/service-configuration-context.xml",
              "classpath:/spring/dao-context.xml",
              "classpath:/spring/service-context.xml");

      INameService nameService = (INameService) context.getBean(NameServiceImpl.BEAN_NAME);

      URL url = NameImport.class.getResource("/importer/names.txt");
      if (url != null)
      {
         try
         {
            BufferedReader nameFile = new BufferedReader(new FileReader(url.getFile()));
            String line;
            while ((line = nameFile.readLine()) != null)
            {
               Name name = new Name();
               name.setValue(line);
               nameService.save(name);
            }
            nameFile.close();
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
