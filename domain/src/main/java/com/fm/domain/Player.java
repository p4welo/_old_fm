package com.fm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "player")
public class Player extends IdentifiableEntity
{
   public static final String FIELD_NAME = "name";

   public static final String FIELD_SURNAME = "surname";

   public static final String FIELD_AGE = "age";

   public static final String FIELD_POSITION = "position";

   public static final String FIELD_PLAYER_STATS = "player_stats";

   public static final String FIELD_TEAM_SID = "teamSid";

   public static final String FIELD_SPEED = "speed";

   public static final String FIELD_STAMINA = "stamina";

   public static final String FIELD_ENERGY = "energy";

   public static final String FIELD_POTENTIAL = "potential";

   public static final String FIELD_CROSSING = "crossing";

   public static final String FIELD_PASSING = "passing";

   public static final String FIELD_HEADING = "heading";

   public static final String FIELD_MARKING = "marking";

   public static final String FIELD_SHOTS = "shots";

   public static final String FIELD_TACKLING = "tackling";

   public static final String FIELD_DRIBBLING = "dribbling";

   public static final String FIELD_GOALKEEPING = "goalkeeping";

   public static final String FIELD_AVATAR_PATH = "avatarPath";

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
   private Integer age;

   @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
   @JoinColumn(nullable = true)
   private Position position;

   @Column(name = "team_sid", nullable = true)
   private String teamSid;

   @Column(name = "avatar_path", nullable = true)
   private String avatarPath;

   //   GENERAL PARAMETERS
   @Column(nullable = false)
   @NotNull
   private Float speed;        // szybkość

   @Column(nullable = false)
   @NotNull
   private Float stamina;      // wytrzymałość

   @Column(nullable = false)
   @NotNull
   private Integer energy;       // energia

   @Column(nullable = false)
   @NotNull
   private Integer potential;       // potencjał

   //   SKILLS
   @Column(nullable = false)
   @NotNull
   private Float crossing;     // dośrodkowania

   @Column(nullable = false)
   @NotNull
   private Float passing;     // podania

   @Column(nullable = false)
   @NotNull
   private Float heading;      // gra głową

   @Column(nullable = false)
   @NotNull
   private Float marking;      // krycie

   @Column(nullable = false)
   @NotNull
   private Float shots;        // strzały

   @Column(nullable = false)
   @NotNull
   private Float tackling;     // odbiór

   @Column(nullable = false)
   @NotNull
   private Float dribbling;    // drybling

   @Column(nullable = false)
   @NotNull
   private Float goalkeeping;  // um. bramkarskie

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

   public Integer getAge()
   {
      return age;
   }

   public void setAge(Integer age)
   {
      this.age = age;
   }

   public Integer getEnergy()
   {
      return energy;
   }

   public void setEnergy(Integer energy)
   {
      this.energy = energy;
   }

   public Integer getPotential()
   {
      return potential;
   }

   public void setPotential(Integer potential)
   {
      this.potential = potential;
   }

   public String getTeamSid()
   {
      return teamSid;
   }

   public void setTeamSid(String teamSid)
   {
      this.teamSid = teamSid;
   }

   public String getAvatarPath()
   {
      return avatarPath;
   }

   public void setAvatarPath(String avatarPath)
   {
      this.avatarPath = avatarPath;
   }

   public Float getSpeed()
   {
      return speed;
   }

   public void setSpeed(Float speed)
   {
      this.speed = speed;
   }

   public Float getStamina()
   {
      return stamina;
   }

   public void setStamina(Float stamina)
   {
      this.stamina = stamina;
   }

   public Float getCrossing()
   {
      return crossing;
   }

   public void setCrossing(Float crossing)
   {
      this.crossing = crossing;
   }

   public Float getPassing()
   {
      return passing;
   }

   public void setPassing(Float passing)
   {
      this.passing = passing;
   }

   public Float getHeading()
   {
      return heading;
   }

   public void setHeading(Float heading)
   {
      this.heading = heading;
   }

   public Float getMarking()
   {
      return marking;
   }

   public void setMarking(Float marking)
   {
      this.marking = marking;
   }

   public Float getShots()
   {
      return shots;
   }

   public void setShots(Float shots)
   {
      this.shots = shots;
   }

   public Float getTackling()
   {
      return tackling;
   }

   public void setTackling(Float tackling)
   {
      this.tackling = tackling;
   }

   public Float getDribbling()
   {
      return dribbling;
   }

   public void setDribbling(Float dribbling)
   {
      this.dribbling = dribbling;
   }

   public Float getGoalkeeping()
   {
      return goalkeeping;
   }

   public void setGoalkeeping(Float goalkeeping)
   {
      this.goalkeeping = goalkeeping;
   }
}
