package com.swift.mt.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderingAccount {
    // Tag:50H: Ordering Customer Account (C*, conditional mandatory) /34a
    // Account number, prefixed with "/"
    private String accountNumber;
    // Ordering customer’s name (C* 35 a)
    // Ordering customer’s name /and address
    // * 50H & 52A have to be present on either Header or Transaction level
    private String name;
    // Ordering customer’s address (O 3x35 a), up to 2-3 lines, each line 35 characters
    private List<String> address;
}