package com.github.welblade.diocitiesapi.countries.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.welblade.diocitiesapi.countries.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {}
