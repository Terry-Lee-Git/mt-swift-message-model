package com.swift.mt.pojos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AccountWithInstitution {
    // Tag:57C: National Clearing System Code (O, optional)
    private String nationalClearingSystemCode;
    // Tag:57A: Beneficiary Bank SWIFT BIC (O, optional)
    private String beneficiaryBankSwiftBic;
}