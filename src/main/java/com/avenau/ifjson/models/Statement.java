package com.avenau.ifjson.models;

public class Statement {
    private String value;

    public Statement (String value){
        this.value = value;
    }

    public String evaluate() {
        return this.value;
    }
}
