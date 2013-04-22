package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.domain.IdentifiableEntity;
import com.fm.domain.ObjectStateEnum;
import com.fm.domain.filter.AbstractFilter;
import com.fm.domain.filter.SortFilterChain;
import com.fm.service.IAbstractService;
import com.fm.service.util.SidUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: pawel
 * Date: 01.12.12
 * Time: 00:24
 */
@Service
public abstract class AbstractServiceImpl<T extends IdentifiableEntity> implements IAbstractService<T>
{
   protected abstract IAbstractDao<T> getDao();

   @Transactional
   public T save(T obj)
   {
      if (obj.getSid() == null)
      {
         obj.setSid(SidUtils.generate());
      }
      if (obj.getObjectState() == null)
      {
         obj.setObjectState(ObjectStateEnum.INACTIVE);
      }
      return getDao().save(obj);
   }

   @Transactional
   public T getRandom()
   {
      return getDao().getRandom();
   }

   @Transactional
   @Deprecated
   public T getById(Long id)
   {
      return getDao().getById(id);
   }

   @Override
   @Transactional
   public List<T> find(int first, int count, String property, boolean ascending)
   {
      return getDao().find(first, count, property, ascending);
   }

   @Override
   @Transactional
   public long getCount()
   {
      return getDao().getCount();
   }

   @Transactional
   public T update(T obj)
   {
      return getDao().update(obj);
   }

   @Transactional
   public void delete(T obj)
   {
      getDao().delete(obj);
   }

   @Transactional
   public void delete(List<T> obj)
   {
      getDao().delete(obj);
   }

   @Transactional
   public List<T> findAll()
   {
      return getDao().findAll();
   }

   @Transactional
   public T getBySid(String sid)
   {
      return getDao().getBySid(sid);
   }

   @Override
   @Transactional(readOnly = true)
   public List<T> findBySearchParams(AbstractFilter filter, SortFilterChain sortFilterChain, int offset, int limit)
   {
      return getDao().findBySearchParams(filter, sortFilterChain, offset, limit);
   }

   @Override
   @Transactional(readOnly = true)
   public long countBySearchParams(AbstractFilter filter)
   {
      return getDao().countBySearchParams(filter);
   }
}
