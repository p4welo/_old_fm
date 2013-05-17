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
   public static final String FIELD_PLAYER_SID = "playerSid";

   public static final String FIELD_PLAYER_NAME = "playerName";

   public static final String FIELD_PLAYER_SURNAME = "playerSurname";

   public static final String FIELD_MATCH_SID = "matchSid";

   public static final String FIELD_SEASON_SID = "seasonSid";

   public static final String FIELD_TEAM_SID = "teamSid";

   public static final String FIELD_MATCH_MINUTE = "matchMinute";

   public static final String FIELD_DATE = "date";

   public static final String FIELD_TYPE = "type";

   @Id
   @GeneratedValue
   @Column
   private Long id;

   @Column(name = "player_sid", nullable = false)
   @NotNull
   private String playerSid;

   @Column(name = "player_name", nullable = false)
   @NotNull
   private String playerName;

   @Column(name = "player_surname", nullable = false)
   @NotNull
   private String playerSurname;

   @Column(name = "match_sid", nullable = false)
   @NotNull
   private String matchSid;

   @Column(name = "season_sid", nullable = false)
   @NotNull
   private String seasonSid;

   @Column(name = "team_sid", nullable = false)
   @NotNull
   private String teamSid;

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

   public String getPlayerName()
   {
      return playerName;
   }

   public void setPlayerName(String playerName)
   {
      this.playerName = playerName;
   }

   public String getPlayerSurname()
   {
      return playerSurname;
   }

   public void setPlayerSurname(String playerSurname)
   {
      this.playerSurname = playerSurname;
   }

   public String getTeamSid()
   {
      return teamSid;
   }

   public void setTeamSid(String teamSid)
   {
      this.teamSid = teamSid;
   }
}
