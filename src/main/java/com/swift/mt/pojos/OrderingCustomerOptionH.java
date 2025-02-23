package com.swift.mt.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//
// Tag 50H Ordering Customer
// (Account) /34x
// (Name and Address) 4*35x
//
public class OrderingCustomerOptionH {
    private String account;

    private String name;
    // Ordering customer’s address (O 3x35 a), up to 2-3 lines, each line 35 characters
    private List<String> address;
}