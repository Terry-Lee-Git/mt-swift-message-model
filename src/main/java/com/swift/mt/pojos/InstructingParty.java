package com.swift.mt.pojos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Field 50a: Instructing Party can be Field 50C or Field 50L
 * <p>
 * Option C
 * (Identifier Code) 4!a2!a2!c[3!c]
 *
 * <p>
 * Option L
 * (Party Identifier) 35x
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructingParty {
    private String identifierCode;
    private String partyIdentifier;
}
