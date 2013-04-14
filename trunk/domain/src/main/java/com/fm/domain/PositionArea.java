package com.fm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 14.04.13
 * Time: 16:59
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "position_area")
public class PositionArea extends IdentifiableEntity
{
   public static final String FIELD_POSITION = "position";

   public static final String FIELD_AREA = "area";

   @Id
   @GeneratedValue
   @Column
   private Long id;

   @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
   @JoinColumn(nullable = false)
   @NotNull
   private Position position;

   @Column(nullable = false)
   @NotNull
   private Integer area;

   @Override
   public Long getId()
   {
      return id;
   }

   @Override
   public void setId(Long id)
   {
      this.id = id;
   }

   public Position getPosition()
   {
      return position;
   }

   public void setPosition(Position position)
   {
      this.position = position;
   }

   public Integer getArea()
   {
      return area;
   }

   public void setArea(Integer area)
   {
      this.area = area;
   }
}
