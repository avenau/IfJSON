package com.avenau.ifjson.dto;

import com.avenau.ifjson.models.Condition;

public class AndConditionDTO implements ConditionDTO{

    private ConditionDTO left;
    private ConditionDTO right;

    public AndConditionDTO (ConditionDTO left, ConditionDTO right){
        this.left = left;
        this.right = right;
    }

    public AndConditionDTO (){

    }


    @Override
    public void print() {
        System.out.println("============ Printing AND Condition ==========");
        this.left.print();
        this.right.print();
        System.out.println("======================");
    }
}
