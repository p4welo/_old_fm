package com.fm.core.cmp.newTable;

import com.fm.domain.IdentifiableEntity;
import com.fm.domain.filter.OpenSearchDescription;
import com.fm.domain.filter.SortFilterChain;
import com.fm.service.IAbstractService;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.IFilterStateLocator;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;

import java.util.Iterator;
import java.util.List;

public class DataProvider<T extends IdentifiableEntity> extends SortableDataProvider<T, String> implements
        IFilterStateLocator<OpenSearchDescription<T>>
{
   private static final long serialVersionUID = 3656923947176480733L;

   private final IAbstractService<T> service;

   private OpenSearchDescription<T> osd;

   public DataProvider(IAbstractService<T> service, OpenSearchDescription<T> osd)
   {
      this.service = service;
      this.osd = osd;
   }

   @Override
   public Iterator<T> iterator(long first, long count)
   {
      return find(first, count).iterator();
   }

   public List<T> find(long first, long count)
   {
      SortParam<String> sortParam = getSort();
      SortFilterChain sortFilterChain;
      if (sortParam != null)
      {
         sortFilterChain = new SortFilterChain(sortParam.getProperty(), !sortParam.isAscending());
      }
      else
      {
         sortFilterChain = osd.getSortFilterChain();
      }

      return service.findBySearchParams(osd.getFilter(), sortFilterChain, (int) first, (int) count);
   }

   @Override
   public long size()
   {
      return service.countBySearchParams(osd.getFilter());
   }

   @Override
   public IModel<T> model(T object)
   {
      return new DetachableModel<T>(object, service);
   }

   @Override
   public OpenSearchDescription<T> getFilterState()
   {
      return osd;
   }

   @Override
   public void setFilterState(OpenSearchDescription<T> osd)
   {
      this.osd = osd;
   }
}
