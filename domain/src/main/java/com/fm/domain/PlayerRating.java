package com.fm.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * User: pawel.radomski
 * Date: 24.05.13
 * Time: 13:38
 */
@Entity
@Table(name = "player_rating")
public class PlayerRating extends IdentifiableEntity
{
   @Id
   @GeneratedValue
   @Column
   private Long id;

   @Column(name = "player_sid", nullable = false, length = 32)
   @NotNull
   @Length(max = 32)
   private String playerSid;

   @Column(name = "match_sid", nullable = false, length = 32)
   @NotNull
   @Length(max = 32)
   private String matchSid;

   @Column(name = "season_sid", nullable = false, length = 32)
   @NotNull
   @Length(max = 32)
   private String seasonSid;

   @Column(name = "creation_date", nullable = false)
   @NotNull
   private Date creationDate;

   @Column(nullable = false)
   @NotNull
   private Float rating;

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

   public Date getCreationDate()
   {
      return creationDate;
   }

   public void setCreationDate(Date creationDate)
   {
      this.creationDate = creationDate;
   }

   public Float getRating()
   {
      return rating;
   }

   public void setRating(Float rating)
   {
      this.rating = rating;
   }
}
