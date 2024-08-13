package com.testenterprise.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GenshinPutRequest {
    private String id;

    private String name;
    private String elementType;
    private String weaponType;
    private String equipmentType;
    private String skill;
}
