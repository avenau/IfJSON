package com.avenau.ifjson.models;

public class IfStatement {

    private IfCondition ifCondition;
    private Statement trueStatement;
    private Statement falseStatement;

    public IfStatement () {

    }

    public IfStatement (Statement trueStatement, Statement falseStatement, IfCondition ifCondition){
        this.trueStatement = trueStatement;
        this.falseStatement = falseStatement;
        this.ifCondition = ifCondition;
    }

    public Statement getFalseStatement() {
        return falseStatement;
    }

    public Statement getTrueStatement() {
        return trueStatement;
    }

    public IfCondition getIfCondition() {
        return ifCondition;
    }

    public void print() {
        trueStatement.print();
        falseStatement.print();
        ifCondition.print();
    }


}
