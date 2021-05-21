package com.github.welblade.diocitiesapi.states.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.welblade.diocitiesapi.states.State;

public interface StateRepository extends JpaRepository<State, Integer>{}