package com.example.springbootannotations;

import com.example.springbootannotations.restmodel.WeatherRJ;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class WeatherRestController {

  private final WeatherService weatherService;

  public WeatherRestController(WeatherService weatherService) {
    this.weatherService = weatherService;
  }

  @RequestMapping(method = RequestMethod.GET, path = "/api/weather/{city}")
  public ResponseEntity<WeatherRJ> getWeather(@PathVariable(value = "city") String city) {
    return weatherService.find(city)
        .map(ResponseEntity::ok)
        .get();
  }

  @RequestMapping(method = RequestMethod.PUT, path = "/api/weather")
  public ResponseEntity<WeatherRJ> putWeather(@Valid @RequestBody WeatherRJ weatherRJ) {
    return Optional.of(weatherRJ)
        .map(weatherService::create)
        .map(ResponseEntity::ok)
        .get();
  }

}
