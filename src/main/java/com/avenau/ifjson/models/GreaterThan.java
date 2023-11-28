package com.avenau.ifjson.models;

public class GreaterThan implements Condition{

    private String variable;
    private int value;
    private int replacement;

    public GreaterThan(){
        this.variable = null;
        this.value =Integer.MIN_VALUE;
        this.replacement = Integer.MIN_VALUE;
    }
    public GreaterThan (String variable, int value){
        this.variable = variable;
        this.value = value;
        this.replacement = Integer.MIN_VALUE;
    }

    public GreaterThan (String variable, int value, int replacement){
        this.variable = variable;
        this.value = value;
        this.replacement = replacement;
    }
    @Override
    public Boolean evaluate() {
        if (replacement == Integer.MIN_VALUE){
            System.out.println("Variable does not have value assigned");
            return false;
        }

        return (replacement > value);
    }

    @Override
    public void print() {
        System.out.println("Condition:{ " + "Type: GreaterThan, " + "variable: " + this.variable + ", Value: " + this.value + ", variable: " + this.value + "}");

    }
}
