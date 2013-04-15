package com.fm.core.cmp.newTable.field;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.EnumChoiceRenderer;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.IModel;

import java.util.*;

public class EnumDropDownField<T extends Enum<T>> extends DropDownChoice<T>
{
   private static final long serialVersionUID = 9018603396362505817L;

   public EnumDropDownField(String id, IModel<T> model, Class<T> enumClass, T... exclude)
   {
      this(id, model, enumClass, new EnumChoiceRenderer(), exclude);
   }

   public EnumDropDownField(final String id, IModel<T> model, T... include)
   {
      super(id, model, (List<T>) null, new EnumChoiceRenderer());
      List<T> enums = new ArrayList<T>();
      enums.addAll(Arrays.asList(include));
      setChoices(enums);
   }

   public EnumDropDownField(final String id, IModel<T> model, Class<T> enumClass, IChoiceRenderer<T> choiceRenderer,
                            T... exclude)
   {
      super(id, model, (List<T>) null, choiceRenderer);
      Iterator<T> iter = EnumSet.allOf(enumClass).iterator();
      List<T> enums = new ArrayList<T>();

      while (iter.hasNext())
      {
         T enm = iter.next();
         if (exclude == null || !contains(enm, exclude))
         {
            enums.add(enm);
         }
      }
      setChoices(enums);
   }

   private boolean contains(T enm, T... exclude)
   {
      for (T obj : exclude)
      {
         if (obj == enm)
         {
            return true;
         }
      }
      return false;
   }
}
