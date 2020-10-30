package com.example.demo.restservice;

import lombok.Value;

@Value
class InnerError {
    String message;
    String target;
}