package com.swift.mt.pojos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Transaction {
    // Tag:21: Transaction Reference Number (M, mandatory) 16a, end-to-end unique reference
    private String transactionReference;

    // Tag:23E: Instruction Code (O, optional) 4a, 23E: tag can occur multiple times in the transaction
    private List<String> instructionCodes;

    // Tag:32B: Currency/Transaction Amount (M, mandatory) 3a15d
    // Amount with decimals preceded by ISO code of currency
    private String currencyAmount;

    // Tag:50H: Ordering Customer (C*, conditional mandatory)
    private OrderingAccount orderingAccount;

    // Tag:52A: Ordering Institution (C*, conditional mandatory) C*8a or 11a
    // * 50H & 52A have to be present on either Header or Transaction level
    private String orderingPartyBankId;

    // Tag:56A: Intermediary Institution (O, optional) 8a or 11a
    // Intermediary bank SWIFT BIC code
    private String intermediaryBankSwiftBic;

    // Tag:57A/C: Account With Institution (O, optional) 8a or 11a
    // Tag 57A: O //34a
    // Tag 57A: M //8a
    // Tag 57C: M //34 a
    // National clearing system code** Beneficiary bank SWIFT BIC code. Mandatory for international payments.
    // If beneficiary bank has no BIC, use TAG:57C: with only national clearing system code instead.
    private AccountWithInstitution accountWithInstitution;

    // Tag:59: Beneficiary (M, mandatory)
    private Beneficiary beneficiary;

    // Tag:70: payment details (O, optional) 4*35a
    // Must contain the split payment details preceded by code words.
    // /TXT/ -> Additional information
    // /VAT/ -> VAT amount with decimal separator
    // /INV/ -> Invoice number
    // /IDC/ -> NIP(Tax ID)
    private List<String> paymentDetails;

    // Tag:77B: Regulatory Reporting (O, optional) 1*35a or 1*14a
    private String regulatoryReporting;

    // Tag:71A: Details of Charges (M, mandatory) 3a
    // SHA (shared)
    // BEN (beneficiary)
    // OUR (ordering customer)
    private String chargeBearer;

    // Tag:23E: Instruction Code (M, Mandatory) 10a, exmaple filled with OTHR/VAT53
    private String instructionCode;

}