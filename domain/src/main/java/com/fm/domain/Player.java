package com.fm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = Player.TABLE_NAME)
public class Player extends IdentifiableEntity
{
   public static final String TABLE_NAME = "player";

   public static final String FIELD_NAME = "name";

   public static final String FIELD_SURNAME = "surname";

   public static final String FIELD_BIRTH = "birth";

   public static final String FIELD_POSITION = "position";

   public static final String FIELD_PLAYER_STATS = "player_stats";

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

   @Column(nullable = false)
   @NotNull
   private Date birth;

   @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
   @JoinColumn(nullable = true)
   private Position position;

   @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
   @JoinColumn(name = "player_stats", nullable = false)
   @NotNull
   private PlayerStats playerStats;

   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   @JoinColumn(nullable = false)
   @NotNull
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

   public Position getPosition()
   {
      return position;
   }

   public void setPosition(Position position)
   {
      this.position = position;
   }

   public Team getTeam()
   {
      return team;
   }

   public void setTeam(Team team)
   {
      this.team = team;
   }

   public Date getBirth()
   {
      return birth;
   }

   public void setBirth(Date birth)
   {
      this.birth = birth;
   }

   public PlayerStats getPlayerStats()
   {
      return playerStats;
   }

   public void setPlayerStats(PlayerStats playerStats)
   {
      this.playerStats = playerStats;
   }
}
