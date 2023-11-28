package com.avenau.ifjson.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public class IfStatement implements Statement{

    @JsonProperty("ifCondition")
    private IfConditionWrapper ifConditionWrapper;
    @JsonProperty("trueStatement")
    private Statement trueStatement;
    @JsonProperty("falseStatement")
    private Statement falseStatement;

    public IfStatement () {

    }

    public IfStatement (Statement trueStatement, Statement falseStatement, IfConditionWrapper ifConditionWrapper){
        this.trueStatement = trueStatement;
        this.falseStatement = falseStatement;
        this.ifConditionWrapper = ifConditionWrapper;
    }

    public Statement getFalseStatement() {
        return falseStatement;
    }

    public Statement getTrueStatement() {
        return trueStatement;
    }

    public IfConditionWrapper getIfCondition() {
        return ifConditionWrapper;
    }

    @Override
    public String evaluate(HashMap<String,String> variableReplacement) throws Exception {
        if (ifConditionWrapper.evaluate(variableReplacement)){
            return this.trueStatement.evaluate(variableReplacement);
        }
        return this.falseStatement.evaluate(variableReplacement);
    }

    public void print() {
        trueStatement.print();
        falseStatement.print();
        ifConditionWrapper.print();
    }


}
