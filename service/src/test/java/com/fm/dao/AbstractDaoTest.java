package com.fm.dao;

import com.fm.domain.IdentifiableEntity;
import com.fm.domain.Name;
import com.fm.domain.ObjectStateEnum;
import com.fm.service.util.SidUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * User: pawel.radomski
 * Date: 10.05.13
 * Time: 16:11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
        {
                "classpath:spring/test-dao-context.xml"
        })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional()
//@Ignore
public class AbstractDaoTest
{
   @Resource
   protected SessionFactory sessionFactory;

   @Test
   public void test()
   {
      Name name = new Name();
      name.setValue("dasdas");
      name.setObjectState(ObjectStateEnum.ACTIVE);
      name.setSid(SidUtils.generate());
      persist(name);
      Assert.assertTrue(true);
   }

   protected void persist(IdentifiableEntity... entries)
   {

      Session session = sessionFactory.getCurrentSession();
      for (IdentifiableEntity entry : entries)
      {
//         sessionFactory.getValidator().validate(entry);
         session.saveOrUpdate(entry);
      }
   }
}
