package com.example.springbootannotations.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherPO, Long> {

  Optional<WeatherPO> findByCity(String city);

}
