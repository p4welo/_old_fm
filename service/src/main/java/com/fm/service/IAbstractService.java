package com.fm.service;

import com.fm.domain.DataEntity;
import com.fm.domain.filter.AbstractFilter;
import com.fm.domain.filter.SortFilterChain;

import java.util.List;

/**
 * UserEntity: pawel
 * Date: 01.12.12
 * Time: 00:22
 */
public interface IAbstractService<T extends DataEntity>
{
   T save(T obj);

   T update(T obj);

   void delete(T obj);

   void delete(List<T> obj);

   List<T> findAll();

   T getRandom();

   T getById(Long id);

   List<T> find(int first, int count, String property, boolean ascending);

   long getCount();

   T getBySid(String sid);

   List<T> findBySearchParams(AbstractFilter filter, SortFilterChain sortFilterChain, int offset, int limit);

   long countBySearchParams(AbstractFilter filter);
}
