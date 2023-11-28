package com.avenau.ifjson.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IfCondition {

    @JsonProperty("condition")
    private Condition condition;

    public IfCondition(){

    }
    public IfCondition(Condition condition){
        this.condition = condition;
    }

    public Condition getCondition(){
        return this.condition;
    }

    public boolean evaluate() {
        return condition.evaluate();
    }
    public void print(){
        System.out.println("====== Printing IfCondition ============");
        this.condition.print();
        System.out.println("====== ======================= ============");
    }

}
