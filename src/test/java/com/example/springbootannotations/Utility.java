package com.example.springbootannotations;

import com.example.springbootannotations.restmodel.WeatherRJ;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class Utility {

  public static String asJsonString(Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static WeatherRJ fromJsonString(String weather) {
    try {
      return new ObjectMapper().readValue(weather, WeatherRJ.class);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
