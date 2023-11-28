package com.avenau.ifjson.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Statement {
    @JsonProperty("value")
    private String value;

    public Statement (String value){
        this.value = value;
    }
    public Statement () {
        this.value = "";
    }

    public String evaluate() {
        return this.value;
    }

    public void print(){
        System.out.println("Statement:{ " + "Value: " + value + " }");
    }
}
