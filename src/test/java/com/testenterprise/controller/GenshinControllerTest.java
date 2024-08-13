package com.testenterprise.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testenterprise.dto.BookDto;
import com.testenterprise.dto.GenshinDto;
import com.testenterprise.dto.request.GenshinPatchRequest;
import com.testenterprise.dto.request.GenshinPutRequest;
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
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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

    private GenshinDto genshinDto;
    private GenshinPatchRequest genshinPatchRequest;
    private GenshinPutRequest genshinPutRequest;

    private String id;

    @BeforeEach
    public void setup() {
        id = "1";
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
                .skill("Feng")
                .build();

        genshinPutRequest = GenshinPutRequest
                .builder()
                .name("Zhongli")
                .elementType("Yan")
                .equipmentType("Qianyan")
                .skill("Jushoubingxu")
                .weaponType("Heiyingqiang")
                .build();
    }

    @Test
    void testGetGenshin() throws Exception {

        when(genshinService.getGenshin(any())).thenReturn(
                new GenshinDto("Lei", "Ying", "Chang qiang", "Jue Yuan", "Wu Xiang De Yi Dao")
        );

        mockMvc.perform(
                        get(version + "/genshin/" + id)
                                .contentType(APPLICATION_JSON_VALUE)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Ying"))
                .andExpect(jsonPath("$.elementType").value("Lei"))
                .andExpect(jsonPath("$.equipmentType").value("Jue Yuan"))
                .andExpect(jsonPath("$.skill").value("Wu Xiang De Yi Dao"))
                .andExpect(jsonPath("$.weaponType").value("Chang qiang"));

        verify(genshinService).getGenshin(id);
    }

    @Test
    void testSaveGenshin() throws Exception {
        doNothing().when(genshinService).saveGenshin(any());

        mockMvc.perform(
                        post(version + "/genshin")
                                .accept(APPLICATION_JSON_VALUE)
                                .contentType(APPLICATION_JSON_VALUE)
                                .content(objectMapper.writeValueAsString(
                                        genshinDto
                                ))
                )
                .andExpect(status().isOk());

        verify(genshinService).saveGenshin(genshinDto);
    }

    @Test
    void testPatchGenshin() throws Exception {
        doNothing().when(genshinService).patchGenshin(any(), any());

        mockMvc.perform(
                patch(version + "/genshin/" + id)
                        .accept(APPLICATION_JSON_VALUE)
                        .contentType(APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(
                               genshinPatchRequest)
                        )
        )
                .andExpect(status().isOk());

        verify(genshinService).patchGenshin(genshinPatchRequest, id);
    }

    @Test
    void testDeleteGenshin() throws Exception {
        doNothing().when(genshinService).deleteGenshin(any());

        mockMvc.perform(
                delete(version + "/genshin/" + id)
                        .contentType(APPLICATION_JSON_VALUE)
        )
                .andExpect(status().isOk());

        verify(genshinService).deleteGenshin(id);
    }

    @Test
    void testPutGenshin() throws Exception {
        doNothing().when(genshinService).putGenshin(any(), any());

        mockMvc.perform(
                put(version + "/genshin/" + id)
                        .accept(APPLICATION_JSON_VALUE)
                        .contentType(APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(
                                genshinPutRequest)
                        )
        )
                .andExpect(status().isOk());
        verify(genshinService).putGenshin(genshinPutRequest, id);
    }
}
