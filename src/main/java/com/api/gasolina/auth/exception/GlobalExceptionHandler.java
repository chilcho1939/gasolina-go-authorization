package com.api.gasolina.auth.exception;

import com.api.gasolina.auth.exception.common.BadRequestException;
import com.api.gasolina.auth.exception.common.EmptyResultsException;
import com.api.gasolina.auth.exception.common.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> generalException(Exception ex, WebRequest request){
        log.error("Error------------> ", ex);
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR);
        apiError.setMessage(ex.getMessage());
        apiError.setCode(99);
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setDebugMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException ex, WebRequest request){
        log.error("Error------------> ", ex);
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        apiError.setCode(91);
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setDebugMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestException(BadRequestException ex, WebRequest request){
        log.error("Error------------> ", ex);
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
        apiError.setCode(90);
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setDebugMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(EmptyResultsException.class)
    public ResponseEntity<?> emptyResultsException(EmptyResultsException ex, WebRequest request){
        log.error("Error------------> ", ex);
        ApiError apiError = new ApiError(HttpStatus.OK);
        apiError.setMessage(ex.getMessage());
        apiError.setCode(90);
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setDebugMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    private ResponseEntity<?> buildResponseEntity(ApiError apiError){
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
