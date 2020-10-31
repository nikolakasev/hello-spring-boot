package com.example.demo.restservice;

import com.example.demo.domain.CreditCheck;
import com.example.demo.domain.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CreditCheckEndpoint {
    @PostMapping("/credit-check")
    public Result get(@Valid @RequestBody CreditCheck creditCheck) {
        return new Result(creditCheck.getReferenceId(), Collections.emptyList(), -1);
    }

    @GetMapping("/")
    public ResponseEntity health() {
        return ResponseEntity.ok("OK");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
