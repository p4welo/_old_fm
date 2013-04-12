package com.fm.dao;

import com.fm.domain.DataEntity;

import java.util.List;

/**
 * UserEntity: pawel
 * Date: 30.11.12
 * Time: 23:59
 */
public interface IAbstractDao<T extends DataEntity>
{
   public T save(T entity);

   public T update(T entity);

   public void delete(T entity);

   public void delete(List<T> entities);

   public void flush();

   public List<T> findAll();

   public T getRandom();

   public T getById(Long id);

   public List<T> find(int first, int count, String property, boolean ascending);

   public long getCount();

   public T getBySid(String sid);
}
