package com.fm.domain.filter;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 15.04.13
 * Time: 22:20
 * To change this template use File | Settings | File Templates.
 */
public class FmFilter extends AbstractFilter
{
   private String name;

   private String surname;

   public String getSurname()
   {
      return surname;
   }

   public void setSurname(String surname)
   {
      this.surname = surname;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }
}
