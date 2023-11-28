package com.avenau.ifjson.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IfWrapper {

    @JsonProperty("ifStatement")
    private IfStatement ifStatement;

    public IfWrapper() {

    }
    public IfWrapper(IfStatement ifStatement){
        this.ifStatement = ifStatement;
    }

    public IfStatement getIfStatement() {
        return ifStatement;
    }

    public void print(){
        ifStatement.print();
    }

}
