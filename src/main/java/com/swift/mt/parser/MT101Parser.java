package com.swift.mt.parser;

import com.prowidesoftware.swift.model.mt.mt1xx.MT101;
import com.swift.mt.pojos.MT101Message;
import com.swift.mt.pojos.OrderingAccount;
import com.swift.mt.pojos.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MT101Parser {

    public MT101Message parse(String swiftMessage) {
        MT101 mt101 = MT101.parse(swiftMessage);
        MT101Message message = new MT101Message();

        message.setSenderReference(mt101.getField20().getValue()); // :20:
        message.setCustomerSpecifiedReference(mt101.getField21R().getValue()); // :21R:
        message.setMessageIndexTotal(mt101.getField28()); // :28D:

        message.setOrderingAccount(parseOrderingAccount(mt101.getField50H())); // :50H
        message.setOrderingPartyBankId(mt101.getField52A()); // :52A:
        message.setExecutionDate(mt101.getField30()); // :30:

        List<Transaction> transactions = parseTransactions(mt101);
        message.setTransactions(transactions);

        return message;
    }

    private OrderingAccount parseOrderingAccount(String field50H) {
        // 根据 Prowide 提供的字段内容解析 OrderingAccount
        OrderingAccount account = new OrderingAccount();
        // 将字段50H拆分并填充字段
        return account;
    }

    private List<Transaction> parseTransactions(MT101 mt101) {
        List<Transaction> transactions = new ArrayList<>();
        // 解析交易，遍历 Transaction 相关字段
        return transactions;
    }
}