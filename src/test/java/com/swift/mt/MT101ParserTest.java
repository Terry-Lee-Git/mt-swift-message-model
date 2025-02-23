package com.swift.mt;

import com.swift.mt.parser.MT101Parser;
import com.swift.mt.pojos.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class MT101ParserTest {

    @Test
    void parseValidMT101Message() throws IOException {
        Path filePath = Paths.get("src/test/resources/MT101/single_mt101_with_single_debit_account.txt");
        String swiftMessage = Files.readString(filePath);

        MT101Parser parser = new MT101Parser();
        MT101MessageDTO message = parser.parse(swiftMessage);

        Assertions.assertEquals("FILEREF1", message.getSenderReference());
        Assertions.assertEquals("UKSUPPLIER090901", message.getCustomerSpecifiedReference());
        Assertions.assertEquals("1/1", message.getMessageIndexTotal());
        Assertions.assertEquals("090905", message.getExecutionDate());

        OrderingCustomerOptionH orderingCustomer = message.getOrderingCustomerOptionH();
        Assertions.assertNotNull(orderingCustomer);
        Assertions.assertEquals("8754219990", orderingCustomer.getAccount());
        Assertions.assertEquals("MAG-NUM INC.", orderingCustomer.getName());
        Assertions.assertEquals(List.of("GENERAL A/C", "BANHOFFSTRASSE 30", "ZURICH, SWITZERLAND"), orderingCustomer.getAddress());

        List<Transaction> transactions = message.getTransactions();
        Assertions.assertEquals(1, transactions.size());

        Transaction transaction1 = transactions.get(0);
        Assertions.assertEquals("TRANSREF1", transaction1.getTransactionReference());
        Assertions.assertEquals("GBP", transaction1.getCurrencyAmount().getCurrency());
        Assertions.assertEquals("12500,", transaction1.getCurrencyAmount().getAmount());
        Assertions.assertEquals("1091282", transaction1.getBeneficiary().getAccountNumber());
        Assertions.assertEquals("Beneficiary 1", transaction1.getBeneficiary().getName());
        Assertions.assertEquals(List.of("LOW STREET 1", "LONDON, UK"), transaction1.getBeneficiary().getAddress());
        Assertions.assertEquals("OUR", transaction1.getChargeBearer());
    }

    @Test
    void parseMT101MessageWithMultipleDebitAccounts() throws IOException {
        Path filePath = Paths.get("src/test/resources/MT101/multiple_mt101_with_multiple_debit_accounts.txt");
        String swiftMessage = Files.readString(filePath);

        MT101Parser parser = new MT101Parser();
        MT101MessageDTO message = parser.parse(swiftMessage);

        Assertions.assertEquals("FILEREF3", message.getSenderReference());
        Assertions.assertEquals("UKSUPPLIER090901", message.getCustomerSpecifiedReference());
        Assertions.assertEquals("1/1", message.getMessageIndexTotal());
        Assertions.assertEquals("090906", message.getExecutionDate());

        List<Transaction> transactions = message.getTransactions();
        Assertions.assertEquals(3, transactions.size());

        Transaction transaction1 = transactions.get(0);
        Assertions.assertEquals("TRANSREF1", transaction1.getTransactionReference());
        Assertions.assertEquals("GBP", transaction1.getCurrencyAmount().getCurrency());
        Assertions.assertEquals("12500,", transaction1.getCurrencyAmount().getAmount());
        Assertions.assertEquals("1091282", transaction1.getBeneficiary().getAccountNumber());
        Assertions.assertEquals("Beneficiary1", transaction1.getBeneficiary().getName());
        Assertions.assertEquals(List.of("LOW STREET 1", "LONDON, UK"), transaction1.getBeneficiary().getAddress());
        Assertions.assertEquals("OUR", transaction1.getChargeBearer());

        Transaction transaction2 = transactions.get(1);
        Assertions.assertEquals("TRANSREF2", transaction2.getTransactionReference());
        Assertions.assertEquals("GBP", transaction2.getCurrencyAmount().getCurrency());
        Assertions.assertEquals("15000,", transaction2.getCurrencyAmount().getAmount());
        Assertions.assertEquals("8123560", transaction2.getBeneficiary().getAccountNumber());
        Assertions.assertEquals("Beneficiary2", transaction2.getBeneficiary().getName());
        Assertions.assertEquals(List.of("HIGH STREET 1", "LONDON, UK"), transaction2.getBeneficiary().getAddress());
        Assertions.assertEquals("OUR", transaction2.getChargeBearer());

        Transaction transaction3 = transactions.get(2);
        Assertions.assertEquals("TRANSREF3", transaction3.getTransactionReference());
        Assertions.assertEquals("GBP", transaction3.getCurrencyAmount().getCurrency());
        Assertions.assertEquals("10000,", transaction3.getCurrencyAmount().getAmount());
        Assertions.assertEquals("2179742", transaction3.getBeneficiary().getAccountNumber());
        Assertions.assertEquals("Beneficiary3", transaction3.getBeneficiary().getName());
        Assertions.assertEquals(List.of("PARK LANE 9", "LONDON, UK"), transaction3.getBeneficiary().getAddress());
        Assertions.assertEquals("OUR", transaction3.getChargeBearer());
    }

    @Test
    void parseMT101MessageWithSingleDebitAccount() throws IOException {
        Path filePath = Paths.get("src/test/resources/MT101/multiple_mt101_with_single_debit_account.txt");
        String swiftMessage = Files.readString(filePath);

        MT101Parser parser = new MT101Parser();
        MT101MessageDTO message = parser.parse(swiftMessage);

        Assertions.assertEquals("FILEREF2", message.getSenderReference());
        Assertions.assertEquals("UKSUPPLIER090901", message.getCustomerSpecifiedReference());
        Assertions.assertEquals("1/1", message.getMessageIndexTotal());
        Assertions.assertEquals("090905", message.getExecutionDate());

        OrderingCustomerOptionH orderingCustomer = message.getOrderingCustomerOptionH();
        Assertions.assertNotNull(orderingCustomer);
        Assertions.assertEquals("8754219990", orderingCustomer.getAccount());
        Assertions.assertEquals("MAG-NUM INC.", orderingCustomer.getName());
        Assertions.assertEquals(List.of("GENERAL A/C", "BAHNOFFSTRASSE 30", "ZURICH, SWITZERLAND"), orderingCustomer.getAddress());

        List<Transaction> transactions = message.getTransactions();
        Assertions.assertEquals(3, transactions.size());

        Transaction transaction1 = transactions.get(0);
        Assertions.assertEquals("TRANSREF1", transaction1.getTransactionReference());
        Assertions.assertEquals("GBP", transaction1.getCurrencyAmount().getCurrency());
        Assertions.assertEquals("12500,", transaction1.getCurrencyAmount().getAmount());
        Assertions.assertEquals("1091282", transaction1.getBeneficiary().getAccountNumber());
        Assertions.assertEquals("Beneficiary 1", transaction1.getBeneficiary().getName());
        Assertions.assertEquals(List.of("LOW STREET 1", "LONDON, UK"), transaction1.getBeneficiary().getAddress());
        Assertions.assertEquals("OUR", transaction1.getChargeBearer());

        Transaction transaction2 = transactions.get(1);
        Assertions.assertEquals("TRANSREF2", transaction2.getTransactionReference());
        Assertions.assertEquals("GBP", transaction2.getCurrencyAmount().getCurrency());
        Assertions.assertEquals("15000,", transaction2.getCurrencyAmount().getAmount());
        Assertions.assertEquals("8123560", transaction2.getBeneficiary().getAccountNumber());
        Assertions.assertEquals("Beneficiary 2", transaction2.getBeneficiary().getName());
        Assertions.assertEquals(List.of("HIGH STREET 1", "LONDON, UK"), transaction2.getBeneficiary().getAddress());
        Assertions.assertEquals("OUR", transaction2.getChargeBearer());

        Transaction transaction3 = transactions.get(2);
        Assertions.assertEquals("TRANSREF3", transaction3.getTransactionReference());
        Assertions.assertEquals("GBP", transaction3.getCurrencyAmount().getCurrency());
        Assertions.assertEquals("10000,", transaction3.getCurrencyAmount().getAmount());
        Assertions.assertEquals("2179742", transaction3.getBeneficiary().getAccountNumber());
        Assertions.assertEquals("Beneficiary 3", transaction3.getBeneficiary().getName());
        Assertions.assertEquals(List.of("PARK LANE 9", "LONDON, UK"), transaction3.getBeneficiary().getAddress());
        Assertions.assertEquals("OUR", transaction3.getChargeBearer());
    }
}