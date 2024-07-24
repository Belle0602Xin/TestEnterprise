package com.testenterprise.service;


import com.testenterprise.Genshin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
public class GenshinServiceTest {

    private GenshinService subject;

    @BeforeEach
    void setUp() throws Exception {
        subject = new GenshinService();
    }

    @Test
    void testGetGenshin() {
        Genshin expected = Genshin
                .builder()
                .name("Ying")
                .elementType("Lei")
                .equipmentType("Jue Yuan")
                .skill("Wu Xiang De Yi Dao")
                .weaponType("Chang qiang")
                .build();

        Genshin actual = subject.getGenshin();

        assertThat(actual).isEqualTo(expected);
    }
}
