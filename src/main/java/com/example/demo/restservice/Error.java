package com.example.demo.restservice;

import lombok.Value;

import java.util.List;

@Value
public class Error {
    String code;
    String message;
    List<InnerError> innerErrors;
}

