package com.fm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * User: pawel
 * Date: 14.12.12
 * Time: 00:22
 */
@Entity
@Table(name = "match_game")
public class MatchGame extends IdentifiableEntity
{
   public static final String FIELD_MATCH_DATE = "matchDate";

   public static final String FIELD_SEASON = "season";

   public static final String FIELD_HOST_SID = "hostSid";

   public static final String FIELD_HOST_NAME = "hostName";

   public static final String FIELD_HOST_SCORES = "hostScores";

   public static final String FIELD_GUEST_SID = "guestSid";

   public static final String FIELD_GUEST_NAME = "guestName";

   public static final String FIELD_GUEST_SCORES = "guestScores";

   public static final String FIELD_ROUND = "round";

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

   @Column(nullable = true)
   @NotNull
   private Integer round;

   @Column(name = "host_sid", nullable = false)
   @NotNull
   private String hostSid;

   @Column(name = "host_name", nullable = false)
   @NotNull
   private String hostName;

   @Column(name = "host_scores", nullable = false)
   @NotNull
   private int hostScores = 0;

   @Column(name = "guest_sid", nullable = false)
   @NotNull
   private String guestSid;

   @Column(name = "guest_name", nullable = false)
   @NotNull
   private String guestName;

   @Column(name = "guest_scores", nullable = false)
   @NotNull
   private int guestScores = 0;

   @Column(nullable = false)
   @Enumerated(value = EnumType.STRING)
   @NotNull
   private MatchGameStatusEnum status;

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

   public Integer getRound()
   {
      return round;
   }

   public void setRound(Integer round)
   {
      this.round = round;
   }

   public String getHostSid()
   {
      return hostSid;
   }

   public void setHostSid(String hostSid)
   {
      this.hostSid = hostSid;
   }

   public String getHostName()
   {
      return hostName;
   }

   public void setHostName(String hostName)
   {
      this.hostName = hostName;
   }

   public String getGuestSid()
   {
      return guestSid;
   }

   public void setGuestSid(String guestSid)
   {
      this.guestSid = guestSid;
   }

   public String getGuestName()
   {
      return guestName;
   }

   public void setGuestName(String guestName)
   {
      this.guestName = guestName;
   }

   public MatchGameStatusEnum getStatus()
   {
      return status;
   }

   public void setStatus(MatchGameStatusEnum status)
   {
      this.status = status;
   }
}
