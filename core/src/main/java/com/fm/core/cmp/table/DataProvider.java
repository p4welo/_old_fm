package com.fm.core.cmp.table;

import com.fm.domain.DataEntity;
import com.fm.domain.IdentifiableEntity;
import com.fm.service.IAbstractService;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;

import java.util.Iterator;

/**
 * User: pawel
 * Date: 26.01.13
 * Time: 13:04
 */
public class DataProvider<T extends IdentifiableEntity> extends SortableDataProvider<T, String>
{
   private IAbstractService<T> service;

   public DataProvider(IAbstractService<T> service)
   {
      this.service = service;
      setSort(DataEntity.FIELD_ID, SortOrder.ASCENDING);
   }

   @Override
   public Iterator<? extends T> iterator(long first, long count)
   {
      return service.find((int) first, (int) count, getSort().getProperty(), getSort().isAscending()).iterator();
   }

   @Override
   public long size()
   {
      return service.getCount();
   }

   @Override
   public IModel<T> model(T entity)
   {
      return new DetachableModel<T>(entity.getSid(), service);
   }
}
