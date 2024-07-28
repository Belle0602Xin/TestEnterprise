package com.testenterprise.mapper;

import com.testenterprise.dto.GenshinDto;
import com.testenterprise.entity.GenshinEntity;
import org.springframework.stereotype.Component;

@Component
public class GenshinMapper {

    public GenshinDto toGenshinDto(GenshinEntity genshinEntity) {
        return GenshinDto
                .builder()
                .name(genshinEntity.getName())
                .elementType(genshinEntity.getElementType())
                .equipmentType(genshinEntity.getEquipmentType())
                .skill(genshinEntity.getSkill())
                .weaponType(genshinEntity.getWeaponType())
                .build();
    }

    public GenshinEntity toGenshinEntity(GenshinDto genshinDto) {
        return GenshinEntity
                .builder()
                .name(genshinDto.getName())
                .elementType(genshinDto.getElementType())
                .equipmentType(genshinDto.getEquipmentType())
                .skill(genshinDto.getSkill())
                .weaponType(genshinDto.getWeaponType())
                .build();
    }
}
