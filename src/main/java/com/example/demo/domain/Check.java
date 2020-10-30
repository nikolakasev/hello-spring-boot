package com.example.demo.domain;

import lombok.Value;

@Value
class Check {
    String text;
    int weight;
    String freeFormatOutcome;
    Outcome genericOutcome;
    Outcome specificOutcome;
    float weightedCreditScore;

    public enum Outcome {
        Compensator,
        Approved,
        Compensated,
        Denied
    }
}
