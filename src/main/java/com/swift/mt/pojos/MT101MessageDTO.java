package com.swift.mt.pojos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * MT101 Message Format
 * <pre>
 * +-------------------------------+------------------------------------+---------------------------------+
 * | Mandatory | Tag               | Description                        | Format                          |
 * +-------------------------------+------------------------------------+---------------------------------+
 * | M         | 20                | Sender's Reference                 |  16x                            |
 * | O         | 21R               | Customer Specified Reference       |  16x                            |
 * | M         | 28D               | Message Index/Total                |  5n/5n                          |
 * | O         | 50a               | Ordering Customer                  | C or L                          |
 * | O         | 50a               | Account Servicing Institution      | F, G, or H                      |
 * | O         | 52a               | Ordering Party Bank Identifier     | A or C                          |
 * | O         | 51A               | Ordering Party Bank Identifier     | [/1!a][/34x]<crlf>4!a2!a2!c[3!c]|
 * | M         | 30                | Requested Execution Date           | 6!n                             |
 * | M         | 25                | Authorisation                      | 35x                             |
 * | O         | Sequence B        | List of transactions               | List<Transaction>               |
 * +-------------------------------+------------------------------------+---------------------------------+
 * </pre>
 *
 * Refer to <a href="https://www2.swift.com/knowledgecentre/publications/us1m_20220722/2.0?topic=mt101-format-spec.htm">...</a>
 */
@Data
@NoArgsConstructor
public class MT101MessageDTO {
    // Tag:20: Sender's Reference, (M, mandatory) 16x
    private String senderReference;
    // Tag:21R: Customer Specified Reference, (O, optional) 16x
    private String customerSpecifiedReference;
    // Tag:28D: Message Index/Total (M, mandatory) 5n/5n
    private String messageIndexTotal;

    // Tag:50a: Ordering Customer (O, optional) C or L
    // Tag:50a: Account Servicing Institution (O, optional) F, G, or H
    private OrderingCustomerOptionF orderingCustomerOptionF;
    private OrderingCustomerOptionG orderingCustomerOptionG;
    private OrderingCustomerOptionH orderingCustomerOptionH;

    // Tag:52A: Ordering Party Bank Identifier (C*, conditional mandatory) C*8a or 11a
    private String orderingPartyBankId;
    // Tag:30: Execution Date (M, mandatory) 6n
    private String executionDate;

    // transactions (M, mandatory)
    private List<Transaction> transactions;
}