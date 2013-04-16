package com.fm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * UserEntity: pawel
 * Date: 14.12.12
 * Time: 00:22
 */
@Entity
@Table(name = "match_game")
public class MatchGame extends IdentifiableEntity
{
   public static final String FIELD_MATCH_DATE = "matchDate";

   public static final String FIELD_SEASON = "season";

   public static final String FIELD_HOST_SCORES = "hostScores";

   public static final String FIELD_GUEST_SCORES = "guestScores";

   @Id
   @GeneratedValue
   @Column
   private Long id;

   @Column(name = "match_date", nullable = false)
   @NotNull
//   @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
   private Date matchDate;

   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   @JoinColumn(nullable = false)
   @NotNull
   private Season season;

   @Column(nullable = false)
   @NotNull
   private int hostScores = 0;

   @Column(nullable = false)
   @NotNull
   private int guestScores = 0;

   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public Date getMatchDate()
   {
      return matchDate;
   }

   public void setMatchDate(Date matchDate)
   {
      this.matchDate = matchDate;
   }

   public Season getSeason()
   {
      return season;
   }

   public void setSeason(Season season)
   {
      this.season = season;
   }

   public int getHostScores()
   {
      return hostScores;
   }

   public void setHostScores(int hostScores)
   {
      this.hostScores = hostScores;
   }

   public int getGuestScores()
   {
      return guestScores;
   }

   public void setGuestScores(int guestScores)
   {
      this.guestScores = guestScores;
   }
}
