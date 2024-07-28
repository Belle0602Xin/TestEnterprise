package com.testenterprise.mapper;

import com.testenterprise.dto.GenshinDto;
import com.testenterprise.entity.GenshinEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GenshinMapperTest {

    private GenshinMapper subject;
    private GenshinEntity genshinEntity;
    private GenshinDto genshinDto;

    @BeforeEach
    public void setUp() {
        subject = new GenshinMapper();

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
    void testToGenshinDto() {

        GenshinDto expected = GenshinDto
                .builder()
                .name("Ying")
                .elementType("Lei")
                .equipmentType("Jue Yuan")
                .skill("Wu Xiang De Yi Dao")
                .weaponType("Chang qiang")
                .build();

        GenshinDto actual = subject.toGenshinDto(genshinEntity);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testToGenshinEntity() {

        GenshinEntity expected = GenshinEntity
                .builder()
                .name("Ying")
                .elementType("Lei")
                .equipmentType("Jue Yuan")
                .skill("Wu Xiang De Yi Dao")
                .weaponType("Chang qiang")
                .build();

        GenshinEntity actual = subject.toGenshinEntity(genshinDto);

        assertThat(actual).isEqualTo(expected);
    }
}
