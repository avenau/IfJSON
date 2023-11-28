package com.avenau.ifjson.models;

public class IfCondition {

    private Condition condition;

    public IfCondition(Condition condition){
        this.condition = condition;
    }

    public boolean evaluate() {
        return condition.execute();
    }

}
