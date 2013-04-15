package com.fm.domain.filter;

import com.fm.domain.IdentifiableEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OpenSearchDescription<T extends IdentifiableEntity> implements Serializable
{
   private static final long serialVersionUID = 7592882384296888888L;

   public static final String FIELD_FILTER = "filter";

   public static final String FIELD_SORT_FILTER_CHAIN = "sortFilterChain";

   public static final String FIELD_SELECTED = "selected";

   private AbstractFilter filter;

   private SortFilterChain sortFilterChain;

   private List<T> selected = new ArrayList<T>();

   public AbstractFilter getFilter()
   {
      return filter;
   }

   public void setFilter(AbstractFilter filter)
   {
      this.filter = filter;
   }

   public SortFilterChain getSortFilterChain()
   {
      return sortFilterChain;
   }

   public void setSortFilterChain(SortFilterChain sortFilterChain)
   {
      this.sortFilterChain = sortFilterChain;
   }

   public List<T> getSelected()
   {
      return selected;
   }

   public void setSelected(List<T> selected)
   {
      this.selected = selected;
   }

   @Override
   public String toString()
   {
      return new ToStringBuilder(this)
              .append("filter", filter)
              .append("sortFilterChain", sortFilterChain)
              .append("selected", selected)
              .toString();
   }
}
