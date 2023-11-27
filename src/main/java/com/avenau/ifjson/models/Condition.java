package com.avenau.ifjson.models;

public class Condition implements ConditionInterface{

    private String type;
    private String variable;
    private String valueType;
    private String value;
    @Override
    public boolean evaluate() {
        return false;
    }
}
