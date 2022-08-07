package com.alkemy.geography.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "icons")

@Getter
@Setter

public class IconEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private String image;

  private String denomination;

  @Column(name = "creation_date")
  @DateTimeFormat(pattern = "yyyy/mm/dd") // Se define el formato de la fecha
  private LocalDate creactionDate;

  private Long height;

  private String history;

  // Definición de la relación muchos a muhos con la tabla countries
  @ManyToMany(mappedBy = "icons", cascade = CascadeType.ALL)
  private List<CountryEntity> countries = new ArrayList<>();

  // Definición del método para agregar paises a la lista
  public void addCountry(CountryEntity country) {
    this.countries.add(country);
  }

  // Definición del método para eliminar paises de la lista
  public void deleteCountry(CountryEntity country) {
    this.countries.remove(country);
  }
}
