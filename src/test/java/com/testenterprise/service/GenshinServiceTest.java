package com.testenterprise.service;


import com.testenterprise.dto.GenshinDto;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class GenshinServiceTest {

    private GenshinService subject;

    @MockBean
    private GenshinRepository genshinRepository;

    @MockBean
    private GenshinMapper genshinMapper;

    private GenshinEntity genshinEntity;
    private GenshinDto genshinDto;

    @BeforeEach
    void setUp() throws Exception {
        subject = new GenshinService(genshinRepository, genshinMapper);
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
    }

    @Test
    void testGetGenshin() {
        when(genshinRepository.findById(any())).thenReturn(Optional.ofNullable(genshinEntity));
        when(genshinMapper.toGenshinDto(any())).thenReturn(genshinDto);

        GenshinDto actual = subject.getGenshin("1");

        verify(genshinRepository).findById("1");
        verify(genshinMapper).toGenshinDto(genshinEntity);

        assertThat(actual).isEqualTo(genshinDto);
    }
}
