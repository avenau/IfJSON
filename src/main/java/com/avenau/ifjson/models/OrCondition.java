package com.avenau.ifjson.models;

import java.util.HashMap;

public class OrCondition implements Condition {

    private Condition left;
    private Condition right;

    public OrCondition(Condition left, Condition right) {
        this.left = left;
        this.right = right;
    }

    public OrCondition() {
        super();
    }

    @Override
    public Boolean evaluate(HashMap<String, String> variableReplacement) throws Exception {
        return (left.evaluate(variableReplacement) || right.evaluate(variableReplacement));
    }

    @Override
    public void print() {
        System.out.println("============ Printing OR Condition ==========");
        this.left.print();
        this.right.print();
        System.out.println("======================");
    }
}
