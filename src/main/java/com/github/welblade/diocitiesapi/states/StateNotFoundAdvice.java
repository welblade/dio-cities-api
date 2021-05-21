package com.github.welblade.diocitiesapi.states;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class StateNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(StateNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String stateNotFoundHandler(StateNotFoundException ex) {
      return ex.getMessage();
    }
}
