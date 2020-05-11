package com.example.springbootannotations.restmodel;

public class WeatherRJ {

  private String city;
  private Integer temperature;

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
