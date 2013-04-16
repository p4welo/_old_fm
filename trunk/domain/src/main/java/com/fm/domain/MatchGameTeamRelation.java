package com.fm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * UserEntity: pawel.radomski
 * Date: 14.12.12
 * Time: 16:22
 */
@Entity
@Table(name = "match_game_team_relation")
public class MatchGameTeamRelation extends IdentifiableEntity
{
   public static final String FIELD_MATCH_GAME = "matchGame";

   public static final String FIELD_TEAM = "team";

   public static final String FIELD_IS_HOST_TEAM = "isHostTeam";

   @Id
   @GeneratedValue
   @Column
   private Long id;

   @Column(nullable = false)
   @NotNull
   private MatchGame matchGame;

   @Column(nullable = false)
   private Team team;

   @Column
   private Boolean isHostTeam;

   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public MatchGame getMatchGame()
   {
      return matchGame;
   }

   public void setMatchGame(MatchGame matchGame)
   {
      this.matchGame = matchGame;
   }

   public Team getTeam()
   {
      return team;
   }

   public void setTeam(Team team)
   {
      this.team = team;
   }

   public Boolean getHostTeam()
   {
      return isHostTeam;
   }

   public void setHostTeam(Boolean hostTeam)
   {
      isHostTeam = hostTeam;
   }
}
