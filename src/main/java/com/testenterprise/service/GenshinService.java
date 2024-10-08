package com.testenterprise.service;

import com.testenterprise.dto.GenshinDto;
import com.testenterprise.dto.request.GenshinPatchRequest;
import com.testenterprise.dto.request.GenshinPutRequest;
import com.testenterprise.entity.GenshinEntity;
import com.testenterprise.mapper.GenshinMapper;
import com.testenterprise.repository.GenshinRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenshinService {

    private GenshinRepository genshinRepository;
    private GenshinMapper genshinMapper;

    public GenshinService(GenshinRepository genshinRepository, GenshinMapper genshinMapper) {
        this.genshinRepository = genshinRepository;
        this.genshinMapper = genshinMapper;
    }

    public void patchGenshin(GenshinPatchRequest genshinPatchRequest, String id) {
        Optional<GenshinEntity> genshinEntityOptional = genshinRepository.findById(id);
        GenshinEntity genshinEntity = genshinEntityOptional.get();

        genshinEntity.setName(genshinPatchRequest.getName());
        genshinEntity.setSkill(genshinPatchRequest.getSkill());

        genshinRepository.save(genshinEntity);
    }

    public void deleteGenshin(String id) {
        genshinRepository.deleteById(id);
    }

    public void putGenshin(GenshinPutRequest genshinPutRequest, String id) {
        Optional<GenshinEntity> genshinEntityOptional = genshinRepository.findById(id);
        GenshinEntity genshinEntity = genshinEntityOptional.get();

        genshinEntity.setName(genshinPutRequest.getName());
        genshinEntity.setElementType(genshinPutRequest.getElementType());
        genshinEntity.setEquipmentType(genshinPutRequest.getEquipmentType());
        genshinEntity.setSkill(genshinPutRequest.getSkill());
        genshinEntity.setWeaponType(genshinPutRequest.getWeaponType());

        genshinRepository.save(genshinEntity);
    }

    public GenshinDto getGenshin(String id) {
        Optional<GenshinEntity> genshinEntityOptional = genshinRepository.findById(id);
        GenshinEntity genshinEntity = genshinEntityOptional.get();

        return genshinMapper.toGenshinDto(genshinEntity);
    }

    public void postGenshin(GenshinDto genshinDto) {
        GenshinEntity genshinEntity = genshinMapper.toGenshinEntity(genshinDto);
        genshinRepository.save(genshinEntity);
    }
}
