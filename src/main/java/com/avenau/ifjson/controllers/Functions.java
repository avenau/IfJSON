package com.avenau.ifjson.controllers;

import com.avenau.ifjson.dto.ModifyDTO;
import com.avenau.ifjson.models.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/json")

public class Functions {
    private IfWrapper currentJson;

    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public String returnJSONTest() throws JsonProcessingException {
        Statement trueStatement = new ResultStatement("True");
        Statement falseStatement = new ResultStatement("False");
        Condition greaterThan = new GreaterThanCondition("A", "5");
        IfConditionWrapper ifConditionWrapper = new IfConditionWrapper(greaterThan);
        IfStatement ifStatement = new IfStatement(trueStatement,falseStatement, ifConditionWrapper);
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
        Statement trueStatement = new ResultStatement("True");
        Statement falseStatement = new ResultStatement("False");
        Condition greaterThan1 = new GreaterThanCondition("A", "5");
        Condition greaterThan2 = new GreaterThanCondition("B", "10");
        Condition AndCond = new AndCondition(greaterThan1,greaterThan2);
        IfConditionWrapper ifConditionWrapper = new IfConditionWrapper(AndCond);
        IfStatement ifStatement = new IfStatement(trueStatement,falseStatement, ifConditionWrapper);
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

    @GetMapping("/test3")
    @ResponseStatus(HttpStatus.OK)
    public String test3() throws JsonProcessingException {
        Statement trueStatement = new ResultStatement("True");
        Statement falseStatement = new ResultStatement("False");
        Condition greaterThan1 = new GreaterThanCondition("A", "5");
        Condition greaterThan2 = new GreaterThanCondition("B", "10");
        Condition AndCond = new AndCondition(greaterThan1,greaterThan2);
        IfConditionWrapper ifConditionWrapper = new IfConditionWrapper(AndCond);
        IfStatement ifStatement = new IfStatement(trueStatement,falseStatement, ifConditionWrapper);
        IfWrapper wrapper = new IfWrapper(ifStatement);
       /* PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
                .allowIfSubType("Condition.")
                .build();*/

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        ObjectMapper mapper = new ObjectMapper();
        //mapper.activateDefaultTyping(ptv, ObjectMapper.DefaultTyping.NON_FINAL);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String json = mapper.writeValueAsString(wrapper);
        currentJson = wrapper;


        return json;
    }

    @GetMapping("/test4")
    @ResponseStatus(HttpStatus.OK)
    public String test4() throws JsonProcessingException {
        Statement trueStatement1 = new ResultStatement("True");
        Statement falseStatement2 = new ResultStatement("False");
        Statement falseStatement = new IfStatement(trueStatement1, falseStatement2, new IfConditionWrapper(new LessThanCondition("b", "10")));

        Statement trueStatement = new ResultStatement("True");
        Condition equals = new EqualsCondition("a", "abc");
        Condition greaterThan = new GreaterThanCondition("b", "4");
        Condition AndCond = new AndCondition(equals,greaterThan);
        IfConditionWrapper ifConditionWrapper = new IfConditionWrapper(AndCond);
        IfStatement ifStatement = new IfStatement(trueStatement,falseStatement, ifConditionWrapper);
        IfWrapper wrapper = new IfWrapper(ifStatement);

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

    @PostMapping("/evaluateTest")
    @ResponseStatus(HttpStatus.OK)
    public String evaluateCurrentJSONTest() throws JsonProcessingException {
        if (currentJson == null) {
            return "{'Error': 'You have not loaded a JSON yet'}";
        }

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String json = mapper.writeValueAsString(currentJson);

        return json;
    }

    @PostMapping("/evaluate")
    @ResponseStatus(HttpStatus.OK)
    public String evaluate(@RequestBody String jsonString) throws Exception {

        if (currentJson == null) {
            return "{'Error': 'You have not loaded a JSON yet'}";
        }

        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> input =  mapper.readValue(jsonString, HashMap.class);
        HashMap<String,String> variables = new HashMap<String, String>();

        for (String key : input.keySet()){
            variables.put(key, String.valueOf(input.get(key)));
        }
        try {
            String result = currentJson.getIfStatement().evaluate(variables);
            return result;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return "{Error: " + e.getMessage() +" }";
        }

    }

    @PostMapping("/modify")
    @ResponseStatus(HttpStatus.OK)
    public String modify(@RequestBody String jsonString) throws Exception {
        if (currentJson == null) {
            return "{'Error': 'You have not loaded a JSON yet'}";
        }


        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        ModifyDTO modifyWrapper =  mapper.readValue(jsonString, ModifyDTO.class);
        IfConditionWrapper oldCondition = modifyWrapper.getOldCondition();
        IfConditionWrapper newCondition = modifyWrapper.getNewCondition();

        String oldConditionJSON = mapper.writeValueAsString(oldCondition);
        String newConditionJSON = mapper.writeValueAsString(newCondition);

        System.out.println("PRINTING CONDITIONS===============================");
        System.out.println(oldConditionJSON);
        System.out.println("NEW    " + newConditionJSON);

        String currentJSONString = mapper.writeValueAsString(currentJson);

        String modifiedJSON = currentJSONString.replace(oldConditionJSON, newConditionJSON);

        System.out.println("Finished Modifying");
        IfWrapper modifiedIf = mapper.readValue(modifiedJSON, IfWrapper.class);
        this.currentJson = modifiedIf;





        return modifiedJSON;

    }

    @GetMapping("/test5")
    @ResponseStatus(HttpStatus.OK)
    public String test5() throws JsonProcessingException {



        Condition equals = new EqualsCondition("a", "abc");
        IfConditionWrapper ifConditionWrapper1 = new IfConditionWrapper(equals);

        Statement trueStatement3 = new ResultStatement("True");
        Statement falseStatement3 = new ResultStatement("False");
        Condition greaterThan1 = new GreaterThanCondition("A", "5");
        Condition greaterThan2 = new GreaterThanCondition("B", "10");
        Condition AndCond3 = new AndCondition(greaterThan1,greaterThan2);
        IfConditionWrapper ifConditionWrapper2 = new IfConditionWrapper(AndCond3);

        ModifyDTO ModifyWrapper = new ModifyDTO(ifConditionWrapper1, ifConditionWrapper2);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String json = mapper.writeValueAsString(ModifyWrapper);

        return json;
    }


}
