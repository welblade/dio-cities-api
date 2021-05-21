package com.github.welblade.diocitiesapi.cities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.welblade.diocitiesapi.cities.City;


public interface CityRepository extends JpaRepository<City, Integer>{}