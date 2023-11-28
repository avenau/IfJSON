package com.avenau.ifjson.controllers;

import com.avenau.ifjson.models.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
@RequestMapping(value = "/json")

public class Functions {
    private IfWrapper currentJson;

    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public String returnJSONTest() throws JsonProcessingException {
        Statement trueStatement = new Statement("True");
        Statement falseStatement = new Statement("False");
        Condition greaterThan = new GreaterThan("A", 5);
        IfCondition ifCondition = new IfCondition(greaterThan);
        IfStatement ifStatement = new IfStatement(trueStatement,falseStatement, ifCondition);
        IfWrapper wrapper = new IfWrapper(ifStatement);
       /* PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
                .allowIfSubType("Condition.")
                .build();*/

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        ObjectMapper mapper = new ObjectMapper();
        //mapper.activateDefaultTyping(ptv, ObjectMapper.DefaultTyping.NON_FINAL);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String json = mapper.writeValueAsString(wrapper);

        return json;
    }

    @GetMapping("/test2")
    @ResponseStatus(HttpStatus.OK)
    public String test() throws JsonProcessingException {
        Statement trueStatement = new Statement("True");
        Statement falseStatement = new Statement("False");
        Condition greaterThan1 = new GreaterThan("A", 5);
        Condition greaterThan2 = new GreaterThan("B", 10);
        Condition AndCond = new AndCondition(greaterThan1,greaterThan2);
        IfCondition ifCondition = new IfCondition(AndCond);
        IfStatement ifStatement = new IfStatement(trueStatement,falseStatement, ifCondition);
        IfWrapper wrapper = new IfWrapper(ifStatement);
       /* PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
                .allowIfSubType("Condition.")
                .build();*/

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        ObjectMapper mapper = new ObjectMapper();
        //mapper.activateDefaultTyping(ptv, ObjectMapper.DefaultTyping.NON_FINAL);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String json = mapper.writeValueAsString(wrapper);

        return json;
    }

    @PostMapping("/recieveTest")
    @ResponseStatus(HttpStatus.OK)
    public String testRecieve(@RequestBody String jsonString) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(jsonString);

        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        IfWrapper ifStatement =  mapper.readValue(jsonString, IfWrapper.class);

        ifStatement.print();

        return "test2";
    }

    @PostMapping("/insertJSON")
    @ResponseStatus(HttpStatus.OK)
    public void insertJSON(@RequestBody String jsonString) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(jsonString);

        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        IfWrapper ifStatement =  mapper.readValue(jsonString, IfWrapper.class);

        currentJson = ifStatement;
    }

    @GetMapping("/getCurrentJSON")
    @ResponseStatus(HttpStatus.OK)
    public String getCurrentJSON() throws JsonProcessingException {
        if (currentJson == null){
            return "{'Error': 'You have not loaded a JSON yet'}";
        }

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        ObjectMapper mapper = new ObjectMapper();
        //mapper.activateDefaultTyping(ptv, ObjectMapper.DefaultTyping.NON_FINAL);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String json = mapper.writeValueAsString(currentJson);

        return json;
    }

    @GetMapping("/evaluate")
    @ResponseStatus(HttpStatus.OK)
    public String evaluateCurrentJSON() throws JsonProcessingException {
        if (currentJson == null) {
            return "{'Error': 'You have not loaded a JSON yet'}";
        }





        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String json = mapper.writeValueAsString(currentJson);

        return json;
    }


}
