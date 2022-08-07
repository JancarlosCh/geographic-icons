package com.alkemy.geography.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "countries")

@Getter
@Setter

public class CountryEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private String image;

  private String denomination;

  @Column(name = "number_of_inhabitants")
  private Long numberOfHabitants;

  private Long surface; // m2

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "continent_id", insertable = false, updatable = false)
  private ContinentEntity continent;

  @Column(name = "continent_id", nullable = false)
  private Long continentID;

  @ManyToMany(
    cascade = {
      CascadeType.PERSIST,
      CascadeType.MERGE
    }
  )

  @JoinTable(
    name = "countries_icons",
    joinColumns = @JoinColumn(name = "country_id"),
    inverseJoinColumns = @JoinColumn(name = "icon_id")
  )
  private Set<IconEntity> icons = new HashSet<>();

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final CountryEntity other = (CountryEntity) obj;
    return other.id == this.id;
  }
}