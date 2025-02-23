package com.swift.mt.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Field 56a: Intermediary
 * Option A
 * (Party Identifier) [/1!a][/34x]
 * (Identifier Code) 4!a2!a2!c[3!c]
 * <p>
 *
 * Option C
 * (Party Identifier) /34x
 *
 * <p>
 * Option D
 * (Party Identifier) [/1!a][/34x]
 * (Name and Address) 4*35x
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Intermediary {
    private String partyIdentifier;
    private String identifierCode;
    private String name;
    private List<String> address;
}
