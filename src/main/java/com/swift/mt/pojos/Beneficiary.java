package com.swift.mt.pojos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class Beneficiary {
    // Tag:59: Beneficiary Account Number (M, mandatory) /34a IBAN or BBAN format
    // IBAN to be used for all IBAN countries
    private String accountNumber;

    // Tag:59: Beneficiary Name (M, mandatory) 35a
    private String name;

    // Tag:59: Beneficiary Address (O, optional) up to 3-4 lines, each line 35 characters
    private List<String> address;
}