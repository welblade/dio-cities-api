package com.github.welblade.diocitiesapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class HttpExceptionAdvice {
    Logger log = LoggerFactory.getLogger(NoHandlerFoundException.class);

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    ResponseEntity<String> NoResourceFoundException(NoHandlerFoundException exception) {
        log.error("error=general message=" + exception.getMessage(), exception);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource not found");
    }
}
