package com.swift.mt.pojos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Transaction {
    // Tag:21: Transaction Reference Number (M, mandatory) 16x, end-to-end unique reference
    private String transactionReference;

    // Tag:21F: F/X Deal Reference (O, optional) 16x
    private String fxDealReference;

    // Tag:23E: Instruction Code (O, optional) 4!c[/30x], example filled with OTHR/VAT53
    private String instructionCode;

    // Tag:25A Charges Account (O, optional) /34x
    private String chargesAccount;

    // Tag:32B: Currency/Transaction Amount (M, mandatory) 3!a15d
    // Amount with decimals preceded by ISO code of currency
    private CurrencyAmount currencyAmount;

    //Tag:33B: Currency/Original Ordered Amount 3!a15d
    private CurrencyAmount originalOrderedAmount;

    //Tag:36: Exchange Rate (O, optional) 12d
    private String exchangeRate;

    // todo Tag:50a C or L
    private InstructingParty instructingParty;

    // Tag:50a: Ordering Customer(O, optional) F, G, or H
    private OrderingCustomerOptionF orderingCustomerOptionF;
    private OrderingCustomerOptionG orderingCustomerOptionG;
    private OrderingCustomerOptionH orderingCustomerOptionH;

    // Tag:51A: Sending Institution (O optional) [/1!a][/34x]<crlf>4!a2!a2!c[3!c]
    private String sendingInstitution;

    // Tag:52A: Ordering Institution (C*, conditional mandatory) C*8a or 11a
    // * 50H & 52A have to be present on either Header or Transaction level
    private String accountServicingInstitution;

    // Tag:56a: Intermediary Institution (O, optional) A, C, or D
    private Intermediary intermediary;

    // Tag:57A/C: Account With Institution (O, optional) 8a or 11a
    // Tag 57A: O //34a
    // Tag 57A: M //8a
    // Tag 57C: M //34 a
    // National clearing system code** Beneficiary bank SWIFT BIC code. Mandatory for international payments.
    // If beneficiary bank has no BIC, use TAG:57C: with only national clearing system code instead.
    private AccountWithInstitution accountWithInstitution;

    // Tag:59: Beneficiary (M, mandatory) No letter option, A, or F
    private Beneficiary beneficiary;

    // Tag:70: payment details (O, optional) 4*35x
    // Must contain the split payment details preceded by code words.
    // /INV/ -> Invoice number
    // /IPI/ -> International Payment Instruction
    // /RFB/ -> Reference for Beneficiary
    // /ROC/ -> Reference of Customer
    // /TSU/ -> Trade Services Utility transaction

    // Example
    // :70:/RFB/BET072
    // :70:/INV/abc/SDF-96//1234-234///ROC/98I
    // U87
    // :70:/TSU/00000089963-0820-01/ABC-15/256
    // 214,
    private List<String> remittanceInformation;

    // Tag:77B: Regulatory Reporting (O, optional) 3*35x
    private List<String> regulatoryReporting;

    // Tag:71A: Details of Charges (M, mandatory) 3!a
    // SHA (shared)
    // BEN (beneficiary)
    // OUR (ordering customer)
    private String chargeBearer;

}