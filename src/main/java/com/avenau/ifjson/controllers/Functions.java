package com.avenau.ifjson.controllers;


import com.avenau.ifjson.dto.IfStatementDTO;
import com.avenau.ifjson.dto.IfWrapperDTO;
import com.avenau.ifjson.models.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
@RequestMapping(value = "/json")

public class Functions {

    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public String returnJSONTest() throws JsonProcessingException {
        Statement trueStatement = new Statement("True");
        Statement falseStatement = new Statement("False");
        Condition condition = new Condition("a", "John");
        IfStatement ifStatement = new IfStatement(trueStatement,falseStatement,condition);
        IfWrapper wrapper = new IfWrapper(ifStatement);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String json = mapper.writeValueAsString(wrapper);

        return json;
    }

    @GetMapping("/test2")
    @ResponseStatus(HttpStatus.OK)
    public String test() throws JsonProcessingException {


        return "test";
    }

    @PostMapping("/recieveTest")
    @ResponseStatus(HttpStatus.OK)
    public String testRecieve(@RequestBody String jsonString) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(jsonString);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        IfWrapperDTO ifStatement =  mapper.readValue(jsonString, IfWrapperDTO.class);

        ifStatement.print();

        return "test2";
    }


}
