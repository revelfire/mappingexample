package com.revelfire.example;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@SpringBootApplication
@ComponentScan({"com.revelfire.example"})
public class Application {

    @Autowired
    ObjectMapper objectMapper;

    public static void main(String [] args) {
        ApplicationContext context = SpringApplication.run(Application.class);
    }

    @PostConstruct
    private void configureJsonObjectMapper() {
        objectMapper.getFactory().enable(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, false);
        //objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
    }
}
