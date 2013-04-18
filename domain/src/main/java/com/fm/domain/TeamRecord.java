package com.fm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * User: pawel
 * Date: 14.12.12
 * Time: 00:05
 */
@Entity
@Table(name = "team_record")
public class TeamRecord extends IdentifiableEntity
{
   public static final String FIELD_TEAM = "team";

   public static final String FIELD_SEASON = "season";

   public static final String FIELD_TEAM_NAME = "teamName";

   public static final String FIELD_ROUND_NUMBER = "roundNumber";

   public static final String FIELD_POINTS_COUNT = "pointsCount";

   public static final String FIELD_GOALS_SCORED = "goalsScored";

   public static final String FIELD_GOALS_ALLOWED = "goalsAllowed";

   public static final String FIELD_GOALS_DIFFERENCE = "goalsDifference";

   public static final String FIELD_WINS_COUNT = "winsCount";

   public static final String FIELD_DRAWS_COUNT = "drawsCount";

   public static final String FIELD_LOSES_COUNT = "losesCount";

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

   @Column(name = "round_number", nullable = false)
   @NotNull
   private Integer roundNumber = 0;

   @Column(name = "points_count", nullable = false)
   @NotNull
   private Integer pointsCount = 0;

   @Column(name = "goals_scored", nullable = false)
   @NotNull
   private Integer goalsScored = 0;

   @Column(name = "goals_allowed", nullable = false)
   @NotNull
   private Integer goalsAllowed = 0;

   @Column(name = "goals_difference", nullable = false)
   @NotNull
   private Integer goalsDifference = 0;

   @Column(name = "wins_count", nullable = false)
   @NotNull
   private Integer winsCount = 0;

   @Column(name = "draws_count", nullable = false)
   @NotNull
   private Integer drawsCount = 0;

   @Column(name = "loses_count", nullable = false)
   @NotNull
   private Integer losesCount = 0;

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

   public Integer getRoundNumber()
   {
      return roundNumber;
   }

   public void setRoundNumber(Integer roundNumber)
   {
      this.roundNumber = roundNumber;
   }

   public Integer getPointsCount()
   {
      return pointsCount;
   }

   public void setPointsCount(Integer pointsCount)
   {
      this.pointsCount = pointsCount;
   }

   public Integer getGoalsScored()
   {
      return goalsScored;
   }

   public void setGoalsScored(Integer goalsScored)
   {
      this.goalsScored = goalsScored;
   }

   public Integer getGoalsAllowed()
   {
      return goalsAllowed;
   }

   public void setGoalsAllowed(Integer goalsAllowed)
   {
      this.goalsAllowed = goalsAllowed;
   }

   public Integer getGoalsDifference()
   {
      return goalsDifference;
   }

   public void setGoalsDifference(Integer goalsDifference)
   {
      this.goalsDifference = goalsDifference;
   }

   public Integer getWinsCount()
   {
      return winsCount;
   }

   public void setWinsCount(Integer winsCount)
   {
      this.winsCount = winsCount;
   }

   public Integer getDrawsCount()
   {
      return drawsCount;
   }

   public void setDrawsCount(Integer drawsCount)
   {
      this.drawsCount = drawsCount;
   }

   public Integer getLosesCount()
   {
      return losesCount;
   }

   public void setLosesCount(Integer losesCount)
   {
      this.losesCount = losesCount;
   }
}
