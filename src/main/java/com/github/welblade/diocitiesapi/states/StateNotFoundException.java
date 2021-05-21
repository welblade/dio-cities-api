package com.github.welblade.diocitiesapi.states;

public class StateNotFoundException extends RuntimeException{
    StateNotFoundException(Integer id) {
        super("Could not find city " + id);
    }
}
