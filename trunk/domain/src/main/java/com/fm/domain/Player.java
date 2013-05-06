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
   private Integer age;

   @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
   @JoinColumn(nullable = true)
   private Position position;

   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   @JoinColumn(nullable = false)
   @NotNull
   private Team team;

   //   GENERAL PARAMETERS
   @Column(nullable = false)
   @NotNull
   private Integer speed;        // szybkość

   @Column(nullable = false)
   @NotNull
   private Integer stamina;      // wytrzymałość

   @Column(nullable = false)
   @NotNull
   private Integer energy;       // energia

   @Column(nullable = false)
   @NotNull
   private Integer potential;       // potencjał

   //   SKILLS
   @Column(nullable = false)
   @NotNull
   private Integer crossing;     // dośrodkowania

   @Column(nullable = false)
   @NotNull
   private Integer passing;     // podania

   @Column(nullable = false)
   @NotNull
   private Integer heading;      // gra głową

   @Column(nullable = false)
   @NotNull
   private Integer marking;      // krycie

   @Column(nullable = false)
   @NotNull
   private Integer shots;        // strzały

   @Column(nullable = false)
   @NotNull
   private Integer tackling;     // odbiór

   @Column(nullable = false)
   @NotNull
   private Integer dribbling;    // drybling

   @Column(nullable = false)
   @NotNull
   private Integer goalkeeping;  // um. bramkarskie

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

   public Integer getAge()
   {
      return age;
   }

   public void setAge(Integer age)
   {
      this.age = age;
   }

   public Integer getSpeed()
   {
      return speed;
   }

   public void setSpeed(Integer speed)
   {
      this.speed = speed;
   }

   public Integer getStamina()
   {
      return stamina;
   }

   public void setStamina(Integer stamina)
   {
      this.stamina = stamina;
   }

   public Integer getEnergy()
   {
      return energy;
   }

   public void setEnergy(Integer energy)
   {
      this.energy = energy;
   }

   public Integer getCrossing()
   {
      return crossing;
   }

   public void setCrossing(Integer crossing)
   {
      this.crossing = crossing;
   }

   public Integer getHeading()
   {
      return heading;
   }

   public void setHeading(Integer heading)
   {
      this.heading = heading;
   }

   public Integer getMarking()
   {
      return marking;
   }

   public void setMarking(Integer marking)
   {
      this.marking = marking;
   }

   public Integer getShots()
   {
      return shots;
   }

   public void setShots(Integer shots)
   {
      this.shots = shots;
   }

   public Integer getTackling()
   {
      return tackling;
   }

   public void setTackling(Integer tackling)
   {
      this.tackling = tackling;
   }

   public Integer getDribbling()
   {
      return dribbling;
   }

   public void setDribbling(Integer dribbling)
   {
      this.dribbling = dribbling;
   }

   public Integer getGoalkeeping()
   {
      return goalkeeping;
   }

   public void setGoalkeeping(Integer goalkeeping)
   {
      this.goalkeeping = goalkeeping;
   }

   public Integer getPotential()
   {
      return potential;
   }

   public void setPotential(Integer potential)
   {
      this.potential = potential;
   }

   public Integer getPassing()
   {
      return passing;
   }

   public void setPassing(Integer passing)
   {
      this.passing = passing;
   }
}
