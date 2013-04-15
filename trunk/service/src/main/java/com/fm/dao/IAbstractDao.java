package com.fm.dao;

import com.fm.domain.DataEntity;
import com.fm.domain.filter.AbstractFilter;
import com.fm.domain.filter.SortFilterChain;

import java.util.List;

/**
 * UserEntity: pawel
 * Date: 30.11.12
 * Time: 23:59
 */
public interface IAbstractDao<T extends DataEntity>
{
   T save(T entity);

   T update(T entity);

   void delete(T entity);

   void delete(List<T> entities);

   void flush();

   List<T> findAll();

   T getRandom();

   T getById(Long id);

   List<T> find(int first, int count, String property, boolean ascending);

   long getCount();

   T getBySid(String sid);

   int countBySearchParams(AbstractFilter filter);

   List<T> findBySearchParams(AbstractFilter filter, SortFilterChain sortFilterChain, int offset, int limit);
}
