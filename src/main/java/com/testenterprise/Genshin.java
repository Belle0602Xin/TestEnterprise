package com.testenterprise;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Genshin {

    private String elementType;
    private String name;
    private String weaponType;
    private String equipmentType;
    private String skill;
}
