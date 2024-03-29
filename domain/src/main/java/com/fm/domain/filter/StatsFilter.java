package com.fm.domain.filter;

import com.fm.domain.PlayerStatsTypeEnum;

/**
 * User: pawel.radomski
 * Date: 17.05.13
 * Time: 11:16
 */
public class StatsFilter extends AbstractFilter
{
   private String matchSid;

   private String seasonSid;

   private String teamSid;

   private String playerSid;

   private PlayerStatsTypeEnum type;

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

   public String getTeamSid()
   {
      return teamSid;
   }

   public void setTeamSid(String teamSid)
   {
      this.teamSid = teamSid;
   }

   public PlayerStatsTypeEnum getType()
   {
      return type;
   }

   public void setType(PlayerStatsTypeEnum type)
   {
      this.type = type;
   }

   public String getPlayerSid()
   {
      return playerSid;
   }

   public void setPlayerSid(String playerSid)
   {
      this.playerSid = playerSid;
   }
}
