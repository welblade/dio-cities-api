package com.github.welblade.diocitiesapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
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

    //Bad Request
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    ResponseEntity<String> BadRequestException(MethodArgumentTypeMismatchException exception) {
        log.error("error=general message=" + exception.getMessage(), exception);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The value '" + exception.getValue().toString() + "' is not valid value for this resource");
    }
    // MissingServletRequestParameterException
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    ResponseEntity<String> NoParamterstException(MissingServletRequestParameterException exception) {
        log.error("error=general message=" + exception.getMessage(), exception);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage().toString());
    }
}
