package com.example.springbootannotations;

import com.example.springbootannotations.restmodel.WeatherRJ;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static com.example.springbootannotations.Utility.asJsonString;
import static com.example.springbootannotations.Utility.fromJsonString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WeatherIntegrationTest {

  @Autowired
  private MockMvc mvc;

  private WeatherRJ weatherRJ;

  @BeforeEach
  public void before() {
    weatherRJ = new WeatherRJ();
    weatherRJ.setCity("zurich");
    weatherRJ.setTemperature(22);
  }

  @Test
  public void testWeatherApi() throws Exception {
    mvc.perform(
        put("/api/weather")
            .contentType(MediaType.APPLICATION_JSON)
            .content(asJsonString(weatherRJ)))
        .andExpect(status().isOk());

    String json = mvc.perform(
        get("/api/weather/zurich"))
        .andReturn().getResponse().getContentAsString();

    assertEquals(22, fromJsonString(json).getTemperature());
  }

}