package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.domain.IdentifiableEntity;
import com.fm.service.IAbstractService;
import com.fm.service.util.SidUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UserEntity: pawel
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
      obj.setSid(SidUtils.generate());
      return getDao().save(obj);
   }

   @Transactional
   public T getRandom()
   {
      return getDao().getRandom();
   }

   @Transactional
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
}
