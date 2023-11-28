package com.avenau.ifjson.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatementDTO {

    @JsonProperty("value")
    private String value;

    public StatementDTO(){
        this.value = "";
    }
    public StatementDTO (String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void print(){
        System.out.println("Statement:{ " + "Value: " + value + " }");
    }
}
