package com.avenau.ifjson.models;

public class IfStatement {

    private Statement trueStatement;
    private Statement falseStatement;
    private Condition condition;

    public IfStatement (Statement trueStatement, Statement falseStatement, Condition condition){
        this.trueStatement = trueStatement;
        this.falseStatement = falseStatement;
        this.condition = condition;
    }
}
