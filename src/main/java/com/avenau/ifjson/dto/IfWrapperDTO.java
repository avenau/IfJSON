package com.avenau.ifjson.dto;

import com.avenau.ifjson.models.IfStatement;
import com.fasterxml.jackson.annotation.JsonProperty;

public class IfWrapperDTO {

    @JsonProperty("ifStatement")
    private IfStatementDTO ifStatement;

    public IfWrapperDTO(){

    }
    public IfWrapperDTO(IfStatementDTO ifStatement){
        this.ifStatement = ifStatement;
    }

    public IfStatementDTO getIfStatement() {
        return this.ifStatement;
    }

    public void print(){
        ifStatement.print();
    }
}
