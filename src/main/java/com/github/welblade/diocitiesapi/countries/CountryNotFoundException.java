package com.github.welblade.diocitiesapi.countries;

public class CountryNotFoundException extends RuntimeException {
    CountryNotFoundException(Long id) {
        super("Could not find country " + id);
      }
}