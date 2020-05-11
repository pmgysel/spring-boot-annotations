package com.example.springbootannotations;

import com.example.springbootannotations.restmodel.WeatherRJ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.OptionalDouble;

@Configuration
@EnableScheduling
public class WeatherStatsTask {

  private final WeatherService weatherService;
  private Logger logger = LoggerFactory.getLogger(WeatherStatsTask.class);

  public WeatherStatsTask(WeatherService service) {
    this.weatherService = service;
  }

  @Scheduled(cron = "${annotations-app.task.cron}")
  public int computeStatistics() {
    int numberOfCities = weatherService.findAll().size();
    OptionalDouble averageTemperature = weatherService
        .findAll()
        .stream()
        .mapToDouble(WeatherRJ::getTemperature)
        .average();

    logger.info("There are currently {} city temperature(s) available.", numberOfCities);
    averageTemperature.ifPresent(avg -> logger.info("Average temperature: {}.", avg));

    return numberOfCities;
  }

}
