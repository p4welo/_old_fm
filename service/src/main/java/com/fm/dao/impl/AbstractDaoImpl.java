package com.fm.dao.impl;

import com.fm.dao.IAbstractDao;
import com.fm.domain.DataEntity;
import com.fm.domain.IdentifiableEntity;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * UserEntity: pawel
 * Date: 30.11.12
 * Time: 23:59
 */
public abstract class AbstractDaoImpl<T extends DataEntity> implements IAbstractDao<T>
{
   @Resource
   private SessionFactory sessionFactory;

   private final Class<?> aClass;

   protected AbstractDaoImpl()
   {
      ParameterizedType daoType = (ParameterizedType) getClass().getGenericSuperclass();
      aClass = (Class<T>) daoType.getActualTypeArguments()[0];
   }

   protected Criteria createCriteria(Class<?> clazz)
   {
      return getSessionFactory().getCurrentSession().createCriteria(clazz);
   }

   protected Criteria createCriteria()
   {
      return createCriteria(aClass);
   }

   public T getRandom()
   {
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
      criteria.setMaxResults(1);
      return (T) criteria.uniqueResult();
   }

   public T getById(Long id)
   {
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.eq(DataEntity.FIELD_ID, id));
      criteria.setMaxResults(1);
      return (T) criteria.uniqueResult();
   }

   @Override
   public List<T> find(int first, int count, String property, boolean ascending)
   {
      Criteria criteria = createCriteria();
      if (ascending)
      {
         criteria.addOrder(Order.asc(property));
      }
      else
      {
         criteria.addOrder(Order.desc(property));
      }
      criteria.setFirstResult(first);
      criteria.setMaxResults(count);
      return criteria.list();
   }

   @Override
   public long getCount()
   {
      Criteria criteria = createCriteria();
      return criteria.list().size();
   }

   @Override
   public T getBySid(String sid)
   {
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.eq(IdentifiableEntity.FIELD_SID, sid));
      criteria.setMaxResults(1);
      return (T) criteria.uniqueResult();
   }

   public T save(T entity)
   {
      getSessionFactory().getCurrentSession().persist(entity);
      return entity;
   }

   public T update(T entity)
   {
      getSessionFactory().getCurrentSession().update(entity);
      return entity;
   }

   public void delete(T entity)
   {
      getSessionFactory().getCurrentSession().delete(entity);
   }

   public void delete(List<T> entities)
   {
      for (T entity : entities)
      {
         getSessionFactory().getCurrentSession().delete(entity);
      }
   }

   public void flush()
   {
      getSessionFactory().getCurrentSession().flush();
   }

   public List<T> findAll()
   {
      return createCriteria().list();
   }

   public SessionFactory getSessionFactory()
   {
      return sessionFactory;
   }
}
