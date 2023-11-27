package com.avenau.ifjson.models;

public class Conditions implements ConditionInterface{

    private ConditionInterface conditions;
    private String type;
    private String variable;
    private String valueType;
    private String value;

    @Override
    public boolean evaluate() {
        return false;
    }
}
