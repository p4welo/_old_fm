package com.fm.dao.impl;

import com.fm.dao.IAbstractDao;
import com.fm.domain.IdentifiableEntity;
import com.fm.service.util.SidUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * User: pawel.radomski
 * Date: 10.05.13
 * Time: 16:11
 */
@ContextConfiguration(locations =
        {
                "classpath:spring/test-dao-context.xml"
        })
@Ignore
public abstract class IdentifiableDaoTest<T extends IdentifiableEntity> extends AbstractDaoTest
{
   @Resource
   protected SessionFactory sessionFactory;

   @Test
   public void getBySid()
   {
      T entity = getEntity();
      persist(entity);
      Assert.assertNotNull(getDao().getBySid(entity.getSid()));
   }

   @Test
   public void testGetByIdUsingCriteria()
   {
      List<T> entities = getEntities();
      persist(entities);
      int randomIndex = new Random().nextInt(entities.size());
      T entity = entities.get(randomIndex);

      T result = getDao().getById(entity.getId());

      assertNotNull(result);
      assertEquals(entity, result);
   }

   @Test
   public void testSave()
   {
      T expected = getDao().save(getEntity());

      IdentifiableEntity result = getDao().getById(expected.getId());

      assertNotNull(result.getId());
      assertEquals(expected, result);
   }

   @Test
   public void testGetById()
   {
      T expected = getEntity();
      persist(expected);

      T result = getDao().getById(expected.getId());

      assertEquals(expected, result);
   }

   @Test
   public void testDelete()
   {
      T entity = getEntity();
      persist(entity);

      T result = getDao().getById(entity.getId());
      assertNotNull(result);

      getDao().delete(entity);

      result = getDao().getById(entity.getId());
      assertNull(result);
   }

   @Test
   public void testGetBySidUsingCriteria()
   {
      List<T> entities = getEntities();
      persist(entities);
      int randomIndex = new Random().nextInt(entities.size());
      T entity = entities.get(randomIndex);

      T result = getDao().getBySid(entity.getSid());

      assertNotNull(result);
      assertEquals(entity, result);
   }

   @Test
   public void testGetBySid()
   {
      T expected = getEntity();
      persist(expected);

      T result = getDao().getBySid(expected.getSid());

      assertEquals(expected, result);
   }

   @Test
   public void testGetByNullSid()
   {
      T result = getDao().getBySid(null);

      assertNull(result);
   }

   @Test
   public void testGetByBlankSid()
   {
      T result = getDao().getBySid("");

      assertNull(result);
   }

   //   @Test
   public void testSaveNonUniqueSid()
   {
      String sameSid = SidUtils.generate();
      T object1 = getEntity();
      object1.setSid(sameSid);
      persist(object1);
      getDao().flush();

      T object1ById = getDao().getById(object1.getId());
      assertNotNull(object1ById);

      T object2 = getEntity();
      object2.setSid(sameSid);

      try
      {
         persist(object2);
         getDao().flush();
         fail();
      }
      catch (ConstraintViolationException e)
      {
         Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
         assertNotNull(constraintViolations);
         boolean wrongSid = false;
         for (ConstraintViolation<?> constraintViolation : constraintViolations)
         {
            if (IdentifiableEntity.NON_UNIQUE_SID_MESSAGE.equals(constraintViolation.getMessage()))
            {
               wrongSid = true;
               break;
            }
         }
         assertEquals(true, wrongSid);
      }
   }

   protected abstract IAbstractDao<T> getDao();

   protected abstract T getEntity();

   protected abstract List<T> getEntities();

   protected void persist(IdentifiableEntity... entries)
   {
      Session session = sessionFactory.getCurrentSession();
      for (IdentifiableEntity entry : entries)
      {
         session.saveOrUpdate(entry);
      }
   }

   protected void persist(List<?> entries)
   {
      Session session = sessionFactory.getCurrentSession();
      for (Object entry : entries)
      {
         session.saveOrUpdate(entry);
      }
   }
}
