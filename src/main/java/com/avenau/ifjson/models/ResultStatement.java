package com.avenau.ifjson.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.swing.plaf.nimbus.State;
import java.util.HashMap;


public class ResultStatement implements Statement {
    @JsonProperty("value")
    private String value;

    public ResultStatement(String value){
        this.value = value;
    }
    public ResultStatement() {
        this.value = "";
    }

    public String evaluate() {
        return this.value;
    }

    @Override
    public String evaluate(HashMap<String, String> variableReplacements) {
        return this.value;
    }

    public void print(){
        System.out.println("Statement:{ " + "Value: " + value + " }");
    }
}
