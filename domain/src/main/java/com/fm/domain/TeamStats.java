package com.fm.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * User: pawel.radomski
 * Date: 24.05.13
 * Time: 16:29
 */
@Entity
@Table(name = "team_stats")
public class TeamStats extends IdentifiableEntity
{
   @Id
   @GeneratedValue
   @Column
   private Long id;

   @Column(name = "team_sid", nullable = false, length = 32)
   @NotNull
   @Length(max = 32)
   private String teamSid;

   @Column(name = "manager_sid", nullable = false, length = 32)
   @NotNull
   @Length(max = 32)
   private String managerSid;

   @Column(name = "season_sid", nullable = false, length = 32)
   @NotNull
   @Length(max = 32)
   private String seasonSid;

   @Column(name = "match_sid", nullable = false, length = 32)
   @NotNull
   @Length(max = 32)
   private String matchSid;

   @Column(nullable = false)
   @Enumerated(value = EnumType.STRING)
   @NotNull
   private TeamStatsTypeEnum type;

   @Column(name = "creation_date", nullable = false)
   @NotNull
   private Date creationDate;

   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public String getTeamSid()
   {
      return teamSid;
   }

   public void setTeamSid(String teamSid)
   {
      this.teamSid = teamSid;
   }

   public String getManagerSid()
   {
      return managerSid;
   }

   public void setManagerSid(String managerSid)
   {
      this.managerSid = managerSid;
   }

   public String getSeasonSid()
   {
      return seasonSid;
   }

   public void setSeasonSid(String seasonSid)
   {
      this.seasonSid = seasonSid;
   }

   public String getMatchSid()
   {
      return matchSid;
   }

   public void setMatchSid(String matchSid)
   {
      this.matchSid = matchSid;
   }

   public TeamStatsTypeEnum getType()
   {
      return type;
   }

   public void setType(TeamStatsTypeEnum type)
   {
      this.type = type;
   }

   public Date getCreationDate()
   {
      return creationDate;
   }

   public void setCreationDate(Date creationDate)
   {
      this.creationDate = creationDate;
   }
}
