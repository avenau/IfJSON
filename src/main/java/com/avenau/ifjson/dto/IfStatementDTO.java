package com.avenau.ifjson.dto;

import com.avenau.ifjson.models.Condition;
import com.avenau.ifjson.models.Statement;
import com.fasterxml.jackson.annotation.JsonProperty;

public class IfStatementDTO {

    @JsonProperty("trueStatement")
    private StatementDTO trueStatement;
    @JsonProperty("falseStatement")
    private StatementDTO falseStatement;
    @JsonProperty("condition")
    private ConditionDTO condition;

    public IfStatementDTO () {

    }
    public IfStatementDTO (StatementDTO trueStatement, StatementDTO falseStatement, ConditionDTO condition){
        this.trueStatement = trueStatement;
        this.falseStatement = falseStatement;
        this.condition = condition;
    }

    public ConditionDTO getCondition() {
        return condition;
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
        condition.print();
    }
}
