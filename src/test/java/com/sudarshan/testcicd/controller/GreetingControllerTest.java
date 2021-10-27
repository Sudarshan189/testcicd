package com.sudarshan.testcicd.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.Assert;

@WebMvcTest(value = GreetingController.class)
@PropertySource(value = "classpath:application-test.yml")
public class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSayHello() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/");
        mockMvc.perform(request).andExpect(result -> Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus()));
    }
}
