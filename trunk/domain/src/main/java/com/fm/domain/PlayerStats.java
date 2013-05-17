package com.fm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * User: pawel
 * Date: 13.12.12
 * Time: 23:14
 */
@Entity
@Table(name = "player_stats")
public class PlayerStats extends IdentifiableEntity
{
   @Id
   @GeneratedValue
   @Column
   private Long id;

   @Column(name = "player_sid", nullable = false)
   @NotNull
   private String playerSid;

   @Column(name = "match_sid", nullable = false)
   @NotNull
   private String matchSid;

   @Column(name = "season_sid", nullable = false)
   @NotNull
   private String seasonSid;

   @Column(name = "match_minute", nullable = true)
   private Integer matchMinute;

   @Column(nullable = false)
   @NotNull
   private Date date;

   @Column(nullable = false)
   @Enumerated(value = EnumType.STRING)
   @NotNull
   private PlayerStatTypeEnum type;

   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public String getPlayerSid()
   {
      return playerSid;
   }

   public void setPlayerSid(String playerSid)
   {
      this.playerSid = playerSid;
   }

   public String getMatchSid()
   {
      return matchSid;
   }

   public void setMatchSid(String matchSid)
   {
      this.matchSid = matchSid;
   }

   public String getSeasonSid()
   {
      return seasonSid;
   }

   public void setSeasonSid(String seasonSid)
   {
      this.seasonSid = seasonSid;
   }

   public Integer getMatchMinute()
   {
      return matchMinute;
   }

   public void setMatchMinute(Integer matchMinute)
   {
      this.matchMinute = matchMinute;
   }

   public Date getDate()
   {
      return date;
   }

   public void setDate(Date date)
   {
      this.date = date;
   }

   public PlayerStatTypeEnum getType()
   {
      return type;
   }

   public void setType(PlayerStatTypeEnum type)
   {
      this.type = type;
   }
}
