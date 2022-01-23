package com.example.spring.interceptor.handlerinterceptor.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerIT
{
    // ============================== [Fields] ==============================

    // -------------------- [Private Fields] --------------------

    @Autowired
    private MockMvc mvc;

    // ============================== [Unit Tests] ==============================

    // -------------------- [Test Helper Classes] --------------------

    // -------------------- [Test Helper Methods] --------------------

    // -------------------- [Test Initialization] --------------------

    // -------------------- [Tests] --------------------

    @Test
    void getTest() throws Exception
    {
        String result = mvc.perform(get("/hello")).andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }

    @Test
    void errorTest() throws Exception
    {
        String result = mvc.perform(get("/hello").param("error", "true")).andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }
}
