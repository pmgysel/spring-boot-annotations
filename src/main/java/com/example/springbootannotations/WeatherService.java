package com.example.springbootannotations;

import com.example.springbootannotations.persistence.WeatherRepository;
import com.example.springbootannotations.restmodel.WeatherRJ;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WeatherService {

  private final WeatherRepository repository;
  private final WeatherMapper mapper;

  public WeatherService(WeatherRepository repository, WeatherMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public WeatherRJ create(WeatherRJ weather) {
    removeIfPresent(weather.getCity());

    return Optional.of(weather)
        .map(mapper::toPO)
        .map(repository::save)
        .map(mapper::toRJ)
        .get();
  }

  public Optional<WeatherRJ> find(String city) {
    return Optional.of(city)
        .flatMap(repository::findByCity)
        .map(mapper::toRJ);
  }

  public List<WeatherRJ> findAll() {
    return repository
        .findAll()
        .stream()
        .map(mapper::toRJ)
        .collect(Collectors.toList());
  }

  private void removeIfPresent(String city) {
    repository.findByCity(city)
        .ifPresent(w -> repository.deleteById(w.getId()));
  }

}
