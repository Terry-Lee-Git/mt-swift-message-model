package com.swift.mt.parser;

import com.prowidesoftware.swift.model.mt.mt1xx.MT101;
import com.prowidesoftware.swift.model.field.*;
import com.swift.mt.pojos.*;

import java.util.ArrayList;
import java.util.List;

public class MT101Parser {

    public MT101MessageDTO parse(String swiftMessage) {
        MT101 mt101 = MT101.parse(swiftMessage);
        MT101MessageDTO message = new MT101MessageDTO();

        if (mt101.getField20() != null) {
            message.setSenderReference(mt101.getField20().getValue()); // :20:
        }
        if (mt101.getField21R() != null) {
            message.setCustomerSpecifiedReference(mt101.getField21R().getValue()); // :21R:
        }
        if (mt101.getField28D() != null) {
            message.setMessageIndexTotal(mt101.getField28D().getValue()); // :28D:
        }
        if (mt101.getField50H() != null && !mt101.getField50H().isEmpty()) {
            message.setOrderingCustomerOptionH(parseOrderingCustomerOptionH(mt101.getField50H().get(0))); // :50H:
        }
        if (mt101.getField52A() != null && !mt101.getField52A().isEmpty()) {
            message.setOrderingPartyBankId(mt101.getField52A().get(0).getValue()); // :52A:
        }
        if (mt101.getField30() != null) {
            message.setExecutionDate(mt101.getField30().getValue()); // :30:
        }

        List<Transaction> transactions = parseTransactions(mt101);
        message.setTransactions(transactions);

        return message;
    }

    private OrderingCustomerOptionH parseOrderingCustomerOptionH(Field50H field50H) {
        OrderingCustomerOptionH orderingCustomer = new OrderingCustomerOptionH();
        orderingCustomer.setAccount(field50H.getAccount());
        orderingCustomer.setName(field50H.getNameAndAddressLine1());
        List<String> address = new ArrayList<>();
        if (field50H.getNameAndAddressLine2() != null) address.add(field50H.getNameAndAddressLine2());
        if (field50H.getNameAndAddressLine3() != null) address.add(field50H.getNameAndAddressLine3());
        if (field50H.getNameAndAddressLine4() != null) address.add(field50H.getNameAndAddressLine4());
        orderingCustomer.setAddress(address);
        return orderingCustomer;
    }

    private List<Transaction> parseTransactions(MT101 mt101) {
        List<Transaction> transactions = new ArrayList<>();
        List<Field21> field21List = mt101.getField21();
        List<Field32B> field32BList = mt101.getField32B();
        List<Field59> field59List = mt101.getField59();
        List<Field71A> field71AList = mt101.getField71A();

        for (int i = 0; i < field21List.size(); i++) {
            Transaction transaction = new Transaction();
            transaction.setTransactionReference(field21List.get(i).getValue()); // :21:

            if (i < field32BList.size() && field32BList.get(i) != null) {
                Field32B field32B = field32BList.get(i);
                CurrencyAmount currencyAmount = new CurrencyAmount();
                currencyAmount.setCurrency(field32B.getCurrency());
                currencyAmount.setAmount(field32B.getAmount());
                transaction.setCurrencyAmount(currencyAmount); // :32B:
            }

            if (i < field59List.size() && field59List.get(i) != null) {
                Field59 field59 = field59List.get(i);
                Beneficiary beneficiary = new Beneficiary();
                beneficiary.setAccountNumber(field59.getAccount());
                beneficiary.setName(field59.getNameAndAddressLine1());
                List<String> address = new ArrayList<>();
                if (field59.getNameAndAddressLine2() != null) address.add(field59.getNameAndAddressLine2());
                if (field59.getNameAndAddressLine3() != null) address.add(field59.getNameAndAddressLine3());
                if (field59.getNameAndAddressLine4() != null) address.add(field59.getNameAndAddressLine4());
                beneficiary.setAddress(address);
                transaction.setBeneficiary(beneficiary); // :59:
            }

            if (i < field71AList.size() && field71AList.get(i) != null) {
                Field71A field71A = field71AList.get(i);
                transaction.setChargeBearer(field71A.getValue()); // :71A:
            }

            transactions.add(transaction);
        }
        return transactions;
    }
}