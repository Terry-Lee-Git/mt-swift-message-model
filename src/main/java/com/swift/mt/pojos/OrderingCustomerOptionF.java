package com.swift.mt.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


// Tag:50F Ordering customer (C\*, conditional mandatory)
// (Account) format: /34x
// (Identifier Code) format: 4\!a2\!a2\!c\[3\!c\]
// refer to https://www2.swift.com/knowledgecentre/publications/us1m_20220722/2.0?topic=con_sfld_HVSpIelYEeuYlf8G2SgDog_410343702fld.htm
//
// Option F - Example 1
// :50F:/12345678
// 1/SMITH JOHN
// 2/299, PARK AVENUE
// 3/US/NEW YORK, NY 10017
//
// Option F - Example 2
// :50F:/BE30001216371411
// 1/PHILIPS MARK
// 3/BE/ANTWERPEN
// 4/19720830
// 5/BE/BRUSSELS

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderingCustomerOptionF {
    private String partyIdentifier;
    private String name;
    private List<String> address;
}