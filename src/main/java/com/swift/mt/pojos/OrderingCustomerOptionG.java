package com.swift.mt.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//
// Tag 50G Ordering Customer
// (Account) /34x
// (Identifier Code) 4!a2!a2!c[3!c]
//
public class OrderingCustomerOptionG {
    // Account number(C*, conditional mandatory), prefixed with "/" "/34x"
    private String account;

    // Tag:50F Party Identifier (C*, conditional mandatory) "/34x"
    private String identifierCode;
}