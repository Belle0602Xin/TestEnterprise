package com.testenterprise.service;

import com.testenterprise.dto.GenshinDto;
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

    public GenshinDto getGenshin(String id) {
        Optional<GenshinEntity> genshinEntityOptional = genshinRepository.findById(id);
        GenshinEntity genshinEntity = genshinEntityOptional.get();

        return genshinMapper.toGenshinDto(genshinEntity);
    }
}
