package com.swift.mt.pojos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CurrencyAmount {
    private String currency;
    private String amount;
}
