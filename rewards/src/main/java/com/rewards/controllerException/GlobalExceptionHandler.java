package com.rewards.controllerException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Handles application-level exceptions.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleBadRequest(IllegalArgumentException ex) {
        return new ResponseEntity<>(
                Map.of("timestamp", LocalDateTime.now(), "error", ex.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneric(Exception ex) {
        return new ResponseEntity<>(
                Map.of("timestamp", LocalDateTime.now(), "error", "Unexpected server error"),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}

