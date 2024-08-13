package com.testenterprise.service;


import com.testenterprise.dto.GenshinDto;
import com.testenterprise.dto.request.GenshinPatchRequest;
import com.testenterprise.dto.request.GenshinPutRequest;
import com.testenterprise.entity.GenshinEntity;
import com.testenterprise.mapper.GenshinMapper;
import com.testenterprise.repository.GenshinRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class GenshinServiceTest {

    private GenshinService subject;

    @MockBean
    private GenshinRepository genshinRepository;

    @MockBean
    private GenshinMapper genshinMapper;

    private GenshinEntity genshinEntity;
    private GenshinEntity patchedGenshinEntity;
    private GenshinEntity putGenshinEntity;
    private GenshinDto genshinDto;
    private GenshinPatchRequest genshinPatchRequest;
    private GenshinPutRequest genshinPutRequest;

    private String id;

    @BeforeEach
    void setUp() throws Exception {
        subject = new GenshinService(genshinRepository, genshinMapper);
        id = "1";
        genshinEntity = GenshinEntity
                .builder()
                .name("Ying")
                .elementType("Lei")
                .equipmentType("Jue Yuan")
                .skill("Wu Xiang De Yi Dao")
                .weaponType("Chang qiang")
                .build();

        genshinDto = GenshinDto
                .builder()
                .name("Ying")
                .elementType("Lei")
                .equipmentType("Jue Yuan")
                .skill("Wu Xiang De Yi Dao")
                .weaponType("Chang qiang")
                .build();

        genshinPatchRequest = GenshinPatchRequest
                .builder()
                .name("Wendi")
                .skill("Xiyiji")
                .build();

        patchedGenshinEntity = GenshinEntity
                .builder()
                .name("Wendi")
                .elementType("Lei")
                .equipmentType("Jue Yuan")
                .skill("Xiyiji")
                .weaponType("Chang qiang")
                .build();

        genshinPutRequest = GenshinPutRequest
                .builder()
                .name("Zhongli")
                .elementType("Yan")
                .equipmentType("Qianyan")
                .skill("Jushoubingxu")
                .weaponType("Heiyingqiang")
                .build();

        putGenshinEntity = GenshinEntity
                .builder()
                .name("Zhongli")
                .elementType("Yan")
                .equipmentType("Qianyan")
                .skill("Jushoubingxu")
                .weaponType("Heiyingqiang")
                .build();
    }

    @Test
    void testPatchGenshin() {
        when(genshinRepository.findById(any())).thenReturn(Optional.ofNullable(genshinEntity));
        when(genshinRepository.save(any())).thenReturn(patchedGenshinEntity);

        subject.patchGenshin(genshinPatchRequest, id);

        verify(genshinRepository).findById(id);
        verify(genshinRepository).save(patchedGenshinEntity);
    }

    @Test
    void testDeleteGenshin() {
        doNothing().when(genshinRepository).deleteById(any());

        subject.deleteGenshin(id);

        verify(genshinRepository).deleteById(id);
    }

    @Test
    void testPutGenshin() {
        when(genshinRepository.findById(any())).thenReturn(Optional.ofNullable(genshinEntity));
        when(genshinRepository.save(any())).thenReturn(putGenshinEntity);

        subject.putGenshin(genshinPutRequest, id);

        verify(genshinRepository).findById(id);
        verify(genshinRepository).save(putGenshinEntity);
    }
}