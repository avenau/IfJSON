package com.avenau.ifjson.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IfStatementDTO {

    @JsonProperty("ifCondition")
    private IfConditionDTO ifCondition;
    @JsonProperty("trueStatement")
    private StatementDTO trueStatement;
    @JsonProperty("falseStatement")
    private StatementDTO falseStatement;


    public IfStatementDTO () {

    }
    public IfStatementDTO (StatementDTO trueStatement, StatementDTO falseStatement, IfConditionDTO ifCondition){
        this.trueStatement = trueStatement;
        this.falseStatement = falseStatement;
        this.ifCondition = ifCondition;
    }

    public IfConditionDTO getIfCondition() {
        return ifCondition;
    }

    public StatementDTO getFalseStatement() {
        return falseStatement;
    }

    public StatementDTO getTrueStatement() {
        return trueStatement;
    }

    public void print() {
        trueStatement.print();
        falseStatement.print();
        ifCondition.print();
    }
}
