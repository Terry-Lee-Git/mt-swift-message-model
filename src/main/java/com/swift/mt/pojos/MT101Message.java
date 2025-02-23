package com.swift.mt.pojos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MT101Message {
    // Tag:20: Sender's Reference, (M, mandatory) 16 a
    private String senderReference;
    // Tag:21R: Customer Specified Reference, (O, optional) 10 a
    private String customerSpecifiedReference;
    // Tag:28D: Message Index/Total (M, mandatory) 5n/5n
    // e.g. 1/1 specifies sequence number in total number of messages
    private String messageIndexTotal;
    // Tag:50H: Ordering Account and Information (C*, conditional mandatory)
    private OrderingAccount orderingAccount;
    // Tag:52A: Ordering Party Bank Identifier (C*, conditional mandatory) C*8a or 11a
    //Ordering party’s BIC or Sort/Bank Code
    //* 50H & 52A have to be present on either Header or Transaction level
    private String orderingPartyBankId;
    // Tag:30: Execution Date (M, mandatory) 6n
    private String executionDate;

    // transactions (M, mandatory)
    private List<Transaction> transactions;
}
