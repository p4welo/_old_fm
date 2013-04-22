package com.fm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "team")
public class Team extends IdentifiableEntity
{
   public static final String FIELD_NAME = "name";

   public static final String FIELD_ACCOUNT = "account";

   public static final String FIELD_LEAGUE = "league";

   public static final String FIELD_TYPE = "type";

   @Id
   @GeneratedValue
   @Column
   private Long id;

   @Column(nullable = false)
   @NotNull
   private String name;

   @Column(nullable = false)
   @NotNull
   private Integer account;

   @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
   @JoinColumn(nullable = true)
   private League league;

   @Column(nullable = false)
   @Enumerated(value = EnumType.STRING)
   @NotNull
   private TeamTypeEnum type;

   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public Integer getAccount()
   {
      return account;
   }

   public void setAccount(Integer account)
   {
      this.account = account;
   }

   public League getLeague()
   {
      return league;
   }

   public void setLeague(League league)
   {
      this.league = league;
   }

   public TeamTypeEnum getType()
   {
      return type;
   }

   public void setType(TeamTypeEnum type)
   {
      this.type = type;
   }
}
