package com.example.CafeOfRecommendations.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class CafeExceptionHandler {

    @ExceptionHandler(NoCoffeeNameForThePreference.class)
    public ResponseEntity<Map<String, String>> handleNoCoffeeNameForThePreference(NoCoffeeNameForThePreference  e){
        Map<String, String> error = Map.of(
                "error", "No Coffee found",
                "message", e.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
