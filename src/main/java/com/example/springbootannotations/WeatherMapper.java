package com.example.springbootannotations;

import com.example.springbootannotations.persistence.WeatherPO;
import com.example.springbootannotations.restmodel.WeatherRJ;
import org.springframework.stereotype.Component;

@Component
public class WeatherMapper {

  public WeatherPO toPO(WeatherRJ rj) {
    WeatherPO po = new WeatherPO();
    po.setCity(rj.getCity());
    po.setTemperature(rj.getTemperature());
    return po;
  }

  public WeatherRJ toRJ(WeatherPO po) {
    WeatherRJ rj = new WeatherRJ();
    rj.setCity(po.getCity());
    rj.setTemperature(po.getTemperature());
    return rj;
  }

}
