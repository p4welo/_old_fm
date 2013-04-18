package com.fm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * User: pawel
 * Date: 13.12.12
 * Time: 23:57
 */
@Entity
@Table(name = "season")
public class Season extends IdentifiableEntity
{
   public static final String FIELD_NUMBER = "number";

   public static final String FIELD_LEAGUE = "league";

   @Id
   @GeneratedValue
   @Column
   private Long id;

   @Column(nullable = false)
   @NotNull
   private int number;

   @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
   @JoinColumn(nullable = false)
   @NotNull
   private League league;

   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public int getNumber()
   {
      return number;
   }

   public void setNumber(int number)
   {
      this.number = number;
   }

   public League getLeague()
   {
      return league;
   }

   public void setLeague(League league)
   {
      this.league = league;
   }
}
