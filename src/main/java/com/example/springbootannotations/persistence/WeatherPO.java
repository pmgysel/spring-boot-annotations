package com.example.springbootannotations.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WeatherPO {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String city;
  private Integer temperature;

  public Long getId() {
    return id;
  }
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }
  public Integer getTemperature() {
    return temperature;
  }
  public void setTemperature(Integer temperature) {
    this.temperature = temperature;
  }
}
