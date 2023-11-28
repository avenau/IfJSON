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
    public Boolean evaluate() {
        return (left.evaluate() && right.evaluate());
    }

    @Override
    public void print() {
        System.out.println("============ Printing AND Condition ==========");
        this.left.print();
        this.right.print();
        System.out.println("======================");
    }
}
