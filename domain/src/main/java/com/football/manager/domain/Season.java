package com.football.manager.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * UserEntity: pawel
 * Date: 13.12.12
 * Time: 23:57
 */
@Entity
@Table(name = Season.TABLE_NAME)
public class Season extends DataEntity
{
   public static final String TABLE_NAME = "season";

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
