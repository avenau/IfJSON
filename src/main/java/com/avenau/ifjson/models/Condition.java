package com.avenau.ifjson.models;

public class Condition {

    private String variable;
    private String value;

    public Condition(String variable, String value){
        this.value = value;
        this.variable =variable;
    }

    public boolean evaluate() {
        return variable.equals(value);
    }

}
