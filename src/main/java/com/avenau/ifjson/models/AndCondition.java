package com.avenau.ifjson.models;

public class AndCondition implements Condition{

    private Condition left;
    private Condition right;

    public AndCondition (Condition left, Condition right){
        this.left = left;
        this.right = right;
    }

    public AndCondition (){

    }
    @Override
    public Boolean execute() {
        return (left.execute() && right.execute());
    }
}
