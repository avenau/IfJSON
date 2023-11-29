package com.avenau.ifjson.controllers;

import com.avenau.ifjson.dto.ModifyDTO;
import com.avenau.ifjson.models.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/json")

public class Functions {
    private IfWrapper currentJson;

    /**
     *
     * @param jsonString Input JSON from API. See example in by running /utility/example1, /utility/example2, /utility/example3
     * @throws JsonProcessingException
     * @Description Inserts If statement into the program. If there is already a if statement stored, it will be replaced by the new one
     */
    @PostMapping("/insertJSON")
    @ResponseStatus(HttpStatus.OK)
    public void insertJSON(@RequestBody String jsonString) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(jsonString);

        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        IfWrapper ifStatement =  mapper.readValue(jsonString, IfWrapper.class);

        currentJson = ifStatement;
    }

    /**
     *
     * @return Return JSON of the if statement that is currently being stored
     * @throws JsonProcessingException
     */
    @GetMapping("/getCurrentJSON")
    @ResponseStatus(HttpStatus.OK)
    public String getCurrentJSON() throws JsonProcessingException {
        if (currentJson == null){
            return "{'Error': 'You have not loaded a JSON yet'}";
        }

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String json = mapper.writeValueAsString(currentJson);

        return json;
    }

    /**
     *
     * @param jsonString JSON inputted from API. The JSON should contain a Hashmap with variables as its key and its corresponding replacement as the value
     * @return It will return JSON of the result of the evaluation
     * @throws Exception
     */

    /*
        Example input:
        {
            "a": 5,
            "b": "abc"
        }
     */
    @PostMapping("/evaluate")
    @ResponseStatus(HttpStatus.OK)
    public String evaluate(@RequestBody String jsonString) throws Exception {

        if (currentJson == null) {
            return "{'Error': 'You have not loaded a JSON yet'}";
        }

        //Reading input JSON
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> input =  mapper.readValue(jsonString, HashMap.class);
        HashMap<String,String> variables = new HashMap<String, String>();

        //Converting HashMap<String, Object> to HashMap<String, String>
        for (String key : input.keySet()){
            variables.put(key, String.valueOf(input.get(key)));
        }

        //Evaluating the If Statement
        try {
            String result = currentJson.getIfStatement().evaluate(variables);
            return result;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return "{Error: " + e.getMessage() +" }";
        }

    }

    /**
     *
     * @Description The API will modify all the conditions that has been passed in and replace the current If Statement with Modified If Statement. See example input by running /utility/exampleModifyInput
     * @param jsonString A ModifyDTO JSON should be passed in, containing the condition that needs to be replaced and its replacement
     * @return Returns the modified if statement
     * @throws Exception
     */
    @PostMapping("/modify")
    @ResponseStatus(HttpStatus.OK)
    public String modify(@RequestBody String jsonString) throws Exception {
        if (currentJson == null) {
            return "{'Error': 'You have not loaded a JSON yet'}";
        }

        // Reading input and mapping it into a class
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        ModifyDTO modifyWrapper =  mapper.readValue(jsonString, ModifyDTO.class);

        //Extracting the conditions from the DTO and turning the conditions back into JSON
        IfConditionWrapper oldCondition = modifyWrapper.getOldCondition();
        IfConditionWrapper newCondition = modifyWrapper.getNewCondition();
        String oldConditionJSON = mapper.writeValueAsString(oldCondition);
        String newConditionJSON = mapper.writeValueAsString(newCondition);

        //Get current if statement in JSON form
        String currentJSONString = mapper.writeValueAsString(currentJson);

        // Replace the conditions in the current if statement
        String modifiedJSON = currentJSONString.replace(oldConditionJSON, newConditionJSON);

        //Turning JSON back into IfWrapper object
        IfWrapper modifiedIf = mapper.readValue(modifiedJSON, IfWrapper.class);

        //Store modified if statement
        this.currentJson = modifiedIf;

        return modifiedJSON;

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


}
