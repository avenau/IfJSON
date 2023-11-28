package com.avenau.ifjson.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConditionDTO {

    @JsonProperty("variable")
    private String variable;
    @JsonProperty("value")
    private String value;

    public ConditionDTO () {
        this.value = "";
        this.variable = "";
    }

    public ConditionDTO(String variable, String value){
        this.value = value;
        this.variable =variable;
    }

    public String getValue() {
        return value;
    }

    public String getVariable() {
        return variable;
    }

    public void print(){
        System.out.println("Condition:{ " + "Variable: " + variable + ", Value: " + value + " }");
    }
}
