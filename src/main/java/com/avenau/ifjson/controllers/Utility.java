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

@RestController
@RequestMapping(value = "/utility")
public class Utility {

    /**
     *
      * @return Example JSON format if statement. Original if statement can be seen below
     * @throws JsonProcessingException
     *
     */
    /*
        Original if statement:
        if ("A" > 5) {
            return "True"
        } else {
            return "False"
        }
     */
    @GetMapping("/example1")
    @ResponseStatus(HttpStatus.OK)
    public String returnExample1() throws JsonProcessingException {
        Statement trueStatement = new ResultStatement("True");
        Statement falseStatement = new ResultStatement("False");
        Condition greaterThan = new GreaterThanCondition("A", "5");
        IfConditionWrapper ifConditionWrapper = new IfConditionWrapper(greaterThan);
        IfStatement ifStatement = new IfStatement(trueStatement,falseStatement, ifConditionWrapper);
        IfWrapper wrapper = new IfWrapper(ifStatement);


        ObjectMapper mapper = new ObjectMapper();

        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String json = mapper.writeValueAsString(wrapper);

        return json;
    }

    /**
     *
     * @return Example JSON format if statement. Original if statement can be seen below
     * @throws JsonProcessingException
     */

    /*
        if ( ("A" > "5") && ("B" > "10")){
            return "True"
        } else {
            return "False"
        }
     */
    @GetMapping("/example2")
    @ResponseStatus(HttpStatus.OK)
    public String returnExample2() throws JsonProcessingException {
        Statement trueStatement = new ResultStatement("True");
        Statement falseStatement = new ResultStatement("False");
        Condition greaterThan1 = new GreaterThanCondition("A", "5");
        Condition greaterThan2 = new GreaterThanCondition("B", "10");
        Condition AndCond = new AndCondition(greaterThan1,greaterThan2);
        IfConditionWrapper ifConditionWrapper = new IfConditionWrapper(AndCond);
        IfStatement ifStatement = new IfStatement(trueStatement,falseStatement, ifConditionWrapper);
        IfWrapper wrapper = new IfWrapper(ifStatement);

        ObjectMapper mapper = new ObjectMapper();

        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String json = mapper.writeValueAsString(wrapper);



        return json;
    }


    /**
     *
     * @return Example JSON format if statement. Original if statement can be seen below
     * @throws JsonProcessingException
     */
    /*
        If (a == “abc” && b > 4) {
            return "True";
        else if (b < 10) {
            return "True";
        } else {
            return "False";
        }

     */
    @GetMapping("/example3")
    @ResponseStatus(HttpStatus.OK)
    public String returnExample3() throws JsonProcessingException {
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


        ObjectMapper mapper = new ObjectMapper();

        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String json = mapper.writeValueAsString(wrapper);


        return json;
    }


    /**
     *
     * @return Returns example Modify Input
     * @throws JsonProcessingException
     */
    @GetMapping("/exampleModifyInput")
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
