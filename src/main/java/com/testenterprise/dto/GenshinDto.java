package com.testenterprise.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GenshinDto {
    @NotBlank
    private String elementType;
    @NotBlank
    private String name;

    private String weaponType;
    private String equipmentType;
    private String skill;
}
