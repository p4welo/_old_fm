package com.fm.service;

import com.fm.domain.DataEntity;

import java.util.List;

/**
 * UserEntity: pawel
 * Date: 01.12.12
 * Time: 00:22
 */
public interface IAbstractService<T extends DataEntity>
{
   public T save(T obj);

   public T update(T obj);

   public void delete(T obj);

   public void delete(List<T> obj);

   public List<T> findAll();

   public T getRandom();

   public T getById(Long id);

   public List<T> find(int first, int count, String property, boolean ascending);

   public long getCount();
}
