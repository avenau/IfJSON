package com.avenau.ifjson.models;

public class BasicCondition{

    private String variable;
    private String value;

    //private String

    public BasicCondition(String variable, String value){
        this.value = value;
        this.variable =variable;
    }
    public boolean evaluate() {
        return variable.equals(value);
    }
}
