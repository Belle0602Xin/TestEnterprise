package com.testenterprise.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testenterprise.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
@ExtendWith(SpringExtension.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private final String version = "/v1";

    @BeforeEach
    public void setup() {
    }

    @Test
    void testGetBooks() throws Exception {
        mockMvc.perform(
                get(version + "/book")
                        .contentType(APPLICATION_JSON_VALUE)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Harry Potter"))
                .andExpect(jsonPath("$.author").value("J.K"))
                .andExpect(jsonPath("$.number").value(1));
    }

    @Test
    void testSaveBooks() throws Exception {
        mockMvc.perform(
                        post(version + "/book")
                                .accept(APPLICATION_JSON_VALUE)
                                .contentType(APPLICATION_JSON_VALUE)
                                .content(objectMapper.writeValueAsString(
                                        new Book(
                                                "One Piece",
                                                "Wei Tian",
                                                95
                                        )
                                ))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("One Piece"))
                .andExpect(jsonPath("$.author").value("Wei Tian"))
                .andExpect(jsonPath("$.number").value(95))
        ;
    }

    @Test
    void testDeleteBooks() throws Exception {
        mockMvc.perform(
                        delete(version + "/book/1")
                                .contentType(APPLICATION_JSON_VALUE)
                )
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateBooks() throws Exception {
        mockMvc.perform(
                        patch(version + "/book/2")
                                .accept(APPLICATION_JSON_VALUE)
                                .contentType(APPLICATION_JSON_VALUE)
                                .content(objectMapper.writeValueAsString(
                                        Book.builder().number(100).build()
                                ))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Harry Potter"))
                .andExpect(jsonPath("$.author").value("J.K"))
                .andExpect(jsonPath("$.number").value(100))
        ;
    }
}
