package com.testenterprise.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "genshin")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenshinEntity {

    @Id
    @GeneratedValue
    private String id;

    private String elementType;
    private String name;
    private String weaponType;
    private String equipmentType;
    private String skill;
}
