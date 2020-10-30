package com.example.demo.domain;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class CreditCheck {
    @NotBlank(message = "Reference Id may not be blank")
    String referenceId;
    @NotBlank(message = "Company Id may not be blank")
    String companyId;
}
