package com.fm.dao.impl;

import com.fm.dao.IAbstractDao;
import com.fm.domain.DataEntity;
import com.fm.domain.IdentifiableEntity;
import com.fm.domain.ObjectStateEnum;
import com.fm.domain.StatefulEntity;
import com.fm.domain.filter.AbstractFilter;
import com.fm.domain.filter.SortFilterChain;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * User: pawel
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

   protected Criteria createCriteria(ObjectStateEnum objectState)
   {
      Criteria criteria = createCriteria(aClass);
      criteria.add(Restrictions.eq(StatefulEntity.FIELD_OBJECT_STATE, objectState));
      return criteria;
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

   @Override
   public int countBySearchParams(AbstractFilter filter)
   {
      Criteria criteria = createCriteriaFromSearchParams(filter);
      criteria.setProjection(Projections.rowCount());
      return (Integer) criteria.uniqueResult();
   }

   @Override
   public List<T> findBySearchParams(AbstractFilter filter, SortFilterChain sortFilterChain, int offset, int limit)
   {
      Criteria criteria = createCriteriaFromSearchParams(filter);
      addOrder(criteria, sortFilterChain);
      applyPaging(criteria, offset, limit);
      return criteria.list();
   }

   protected void applyPaging(Criteria criteria, int offset, int limit)
   {
      criteria.setMaxResults(limit);
      criteria.setFirstResult(offset);
   }

   public Criteria createCriteriaFromSearchParams(AbstractFilter abstractFilter)
   {
      return createCriteria();
   }

   protected String[] getAllowedSortFields()
   {
      return null;
   }

   public boolean isSortFieldAllowed(SortFilterChain sortFilterChain)
   {
      if (!StringUtils.isBlank(sortFilterChain.getField()))
      {
         String[] sortFields = getAllowedSortFields();
         if (sortFields == null)
         {
            return true;
         }
         else
         {
            for (String sortField : sortFields)
            {
               if (sortFilterChain.getField().equals(sortField))
               {
                  return true;
               }
            }
         }
      }
      return false;
   }

   private void addOrder(Criteria criteria, SortFilterChain sortFilterChain)
   {
      if (sortFilterChain != null)
      {
         while (sortFilterChain != null)
         {
            if (isSortFieldAllowed(sortFilterChain))
            {
               criteria.addOrder(sortFilterChain.isAscending() ? Order.asc(sortFilterChain.getField()) : Order
                       .desc(sortFilterChain.getField()));
            }
            sortFilterChain = sortFilterChain.getNext();
         }
      }
      else
      {
         if (getOrderFields() != null && getOrderFields().length > 0)
         {
            for (String sortField : getOrderFields())
            {
               criteria.addOrder(isOrderAsc() ? Order.asc(sortField) : Order.desc(sortField));
            }
         }
      }
   }

   protected boolean isOrderAsc()
   {
      return true;
   }

   protected String[] getOrderFields()
   {
      return new String[]
              {
                      DataEntity.FIELD_ID
              };
   }
}
