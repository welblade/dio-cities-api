package com.github.welblade.diocitiesapi.cities;

public class CityNotFoundException extends RuntimeException {
  CityNotFoundException(Integer id) {
    super("Could not find city " + id);
  }
}
