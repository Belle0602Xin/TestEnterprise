package com.testenterprise.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testenterprise.dto.GenshinDto;
import com.testenterprise.service.GenshinService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GenshinController.class)
@ExtendWith(SpringExtension.class)
public class GenshinControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GenshinService genshinService;

    @Autowired
    private ObjectMapper objectMapper;

    private final String version = "/v1";

    @BeforeEach
    public void setup() {
    }

    @Test
    void testGetGenshin() throws Exception {

        when(genshinService.getGenshin(any())).thenReturn(
                new GenshinDto("Lei", "Ying", "Chang qiang", "Jue Yuan", "Wu Xiang De Yi Dao")
        );

        mockMvc.perform(
                        get(version + "/genshin/1")
                                .contentType(APPLICATION_JSON_VALUE)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Ying"))
                .andExpect(jsonPath("$.elementType").value("Lei"))
                .andExpect(jsonPath("$.equipmentType").value("Jue Yuan"))
                .andExpect(jsonPath("$.skill").value("Wu Xiang De Yi Dao"))
                .andExpect(jsonPath("$.weaponType").value("Chang qiang"));

        verify(genshinService).getGenshin("1");
    }
}
