package com.testenterprise.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GenshinDto {

    private String elementType;
    private String name;
    private String weaponType;
    private String equipmentType;
    private String skill;
}
