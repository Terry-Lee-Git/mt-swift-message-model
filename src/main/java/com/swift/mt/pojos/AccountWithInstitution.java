package com.swift.mt.pojos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Field 57a: Account With Institution
 * <p>
 * Option A	Tag:57A
 * (Party Identifier) [/1!a][/34x]
 * (Identifier Code) 4!a2!a2!c[3!c]
 * <p>
 *
 * Option C	Tag:57C
 * (Party Identifier) /34x
 *
 * <p>
 * Option D	Tag:57D
 * (Party Identifier) [/1!a][/34x]
 * (Name and Address) 4*35x
 *
 */
@NoArgsConstructor
@Data
public class AccountWithInstitution {
    // for Tag:57A/Tag:57C/Tag:57D: Party Identifier (C*, conditional mandatory) "/34x"
    private String partyIdentifier;
    // for Tag:57A: Beneficiary Bank SWIFT BIC (O, optional)
    private String identifierCode;
    // for Tag:57D
    private String name;
    // for Tag:57D
    private List<String> address;
}