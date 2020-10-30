package com.example.demo.domain;

import lombok.Value;

import java.util.List;

@Value
public class Result {
    String referenceId;
    List<Check> checks;
    float totalWeightedScore;
}
