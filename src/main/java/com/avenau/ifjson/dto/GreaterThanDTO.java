package com.avenau.ifjson.dto;

public class GreaterThanDTO implements ConditionDTO{

    private String variable;
    private int value;
    private int replacement;

    public GreaterThanDTO(){
        this.variable = null;
        this.value =Integer.MIN_VALUE;
        this.replacement = Integer.MIN_VALUE;
    }
    public GreaterThanDTO(String variable, String value){
        this.variable = variable;
        this.value = Integer.MIN_VALUE;
        this.replacement = Integer.MIN_VALUE;
    }

    public GreaterThanDTO (String variable, String value, String replacement){
        this.variable = variable;
        this.value = Integer.MIN_VALUE;
        this.replacement = Integer.MIN_VALUE;
    }

    @Override
    public void print() {
        System.out.println("Condition:{ " + "Type: GreaterThan, " + "variable: " + this.variable + "Value: " + this.value + "variable: " + this.value + "}");
    }
}
