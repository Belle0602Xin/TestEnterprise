package com.testenterprise.service;

import com.testenterprise.Genshin;
import org.springframework.stereotype.Service;

@Service
public class GenshinService {

    public Genshin getGenshin() {
        return Genshin
                .builder()
                .name("Ying")
                .elementType("Lei")
                .equipmentType("Jue Yuan")
                .skill("Wu Xiang De Yi Dao")
                .weaponType("Chang qiang")
                .build();
    }
}
