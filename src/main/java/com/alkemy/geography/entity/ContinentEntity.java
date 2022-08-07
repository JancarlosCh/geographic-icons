package com.alkemy.geography.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "continents")

@Getter
@Setter

public class ContinentEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private String image;

  private String denomination;
}