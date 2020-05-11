package com.example.springbootannotations;

import com.example.springbootannotations.restmodel.WeatherRJ;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class WeatherStatsTaskTest {

  @InjectMocks
  private WeatherStatsTask task;
  @Mock
  private WeatherService weatherService;

  private WeatherRJ weatherRJ;

  @BeforeEach
  public void before() {
    weatherRJ = new WeatherRJ();
    weatherRJ.setCity("zurich");
    weatherRJ.setTemperature(22);
  }

  @Test
  public void testTask() {
    doReturn(Arrays.asList(weatherRJ)).when(weatherService).findAll();

    int numOfCities = task.computeStatistics();

    assertEquals(1, numOfCities);
  }

}