package com.avenau.ifjson.models;

public class EqualsCondition {
    private String variable;
    private String value;

    public EqualsCondition(String variable, String value){
        this.value = value;
        this.variable =variable;
    }
    public boolean evaluate() {
        return variable.equals(value);
    }
}
