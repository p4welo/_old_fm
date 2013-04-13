package com.fm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = Manager.TABLE_NAME)
public class Manager extends IdentifiableEntity
{
   public static final String TABLE_NAME = "manager";

   public static final String FIELD_NAME = "name";

   public static final String FIELD_SURNAME = "surname";

   public static final String FIELD_TEAM = "team";

   @Id
   @GeneratedValue
   @Column
   private Long id;

   @Column(nullable = false)
   @NotNull
   private String name;

   @Column(nullable = false)
   @NotNull
   private String surname;

   @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
   @JoinColumn(nullable = true)
   private Team team;

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

   public String getSurname()
   {
      return surname;
   }

   public void setSurname(String surname)
   {
      this.surname = surname;
   }

   public Team getTeam()
   {
      return team;
   }

   public void setTeam(Team team)
   {
      this.team = team;
   }
}
