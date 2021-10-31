package com.sudarshan.testcicd.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;
import com.sudarshan.testcicd.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/")
public class GreetingController {

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String sayHello() {
        Person person = new Person();
        person.setId(100L);
        person.setFirstName("Sudarshan");
        person.setLastName("Shanbhag");
        return "Hello World!!";
    }

    @GetMapping("/person")
    @ResponseStatus(HttpStatus.OK)
    public String getPerson() throws JsonProcessingException {
        Person person = new Person();
        person.setId(100L);
        person.setFirstName("Sudarshan");
        person.setLastName("Shanbhag");

        JsonSchemaGenerator jsonSchemaGenerator = new JsonSchemaGenerator(objectMapper);
        JsonSchema jsonSchema = jsonSchemaGenerator.generateSchema(Person.class);


        return objectMapper.writeValueAsString(jsonSchema);
    }
}
