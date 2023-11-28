package com.avenau.ifjson.models;

public class IfStatement {

    private IfCondition ifCondition;
    private Statement trueStatement;
    private Statement falseStatement;

    public IfStatement (Statement trueStatement, Statement falseStatement, IfCondition ifCondition){
        this.trueStatement = trueStatement;
        this.falseStatement = falseStatement;
        this.ifCondition = ifCondition;
    }
}
