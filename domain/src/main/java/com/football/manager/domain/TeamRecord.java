package com.football.manager.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * UserEntity: pawel
 * Date: 14.12.12
 * Time: 00:05
 */
@Entity
@Table(name = TeamRecord.TABLE_NAME)
public class TeamRecord extends DataEntity
{
   public static final String TABLE_NAME = "team_record";

   public static final String FIELD_TEAM = "team";

   public static final String FIELD_SEASON = "season";

   public static final String FIELD_TEAM_NAME = "teamName";

   @Id
   @GeneratedValue
   @Column
   private Long id;

   @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
   @JoinColumn()
   private Team team;

   @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
   @JoinColumn(nullable = false)
   @NotNull
   private Season season;

   @Column(name = "team_name", nullable = false)
   @NotNull
   private String teamName;

   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public Team getTeam()
   {
      return team;
   }

   public void setTeam(Team team)
   {
      this.team = team;
   }

   public Season getSeason()
   {
      return season;
   }

   public void setSeason(Season season)
   {
      this.season = season;
   }

   public String getTeamName()
   {
      return teamName;
   }

   public void setTeamName(String teamName)
   {
      this.teamName = teamName;
   }
}
