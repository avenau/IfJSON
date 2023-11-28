package com.avenau.ifjson.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public class IfConditionWrapper {

    @JsonProperty("condition")
    private Condition condition;

    public IfConditionWrapper(){

    }
    public IfConditionWrapper(Condition condition){
        this.condition = condition;
    }

    public Condition getCondition(){
        return this.condition;
    }

    public boolean evaluate(HashMap<String,String> variableReplacement) throws Exception {
        return condition.evaluate(variableReplacement);
    }
    public void print(){
        System.out.println("====== Printing IfCondition ============");
        this.condition.print();
        System.out.println("====== ======================= ============");
    }

}
