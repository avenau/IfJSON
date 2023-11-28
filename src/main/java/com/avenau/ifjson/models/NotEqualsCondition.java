package com.avenau.ifjson.models;

import org.apache.catalina.valves.rewrite.RewriteCond;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

public class NotEqualsCondition implements Condition {
    private String variable;
    private String value;

    public NotEqualsCondition() {
        this.variable = null;
        this.value = null;
    }

    public NotEqualsCondition(String variable, String value) {
        this.variable = variable;
        this.value = value;
    }

    @Override
    public Boolean evaluate(HashMap<String, String> variableReplacement) throws Exception {
        if (variableReplacement.containsKey(variable)) {
            if (!StringUtils.isNumeric(value) || !StringUtils.isNumeric(variableReplacement.get(variable))) {
                return (variableReplacement.get(variable).compareTo(value) != 0);
            } else if (StringUtils.isNumeric(value) && StringUtils.isNumeric(variableReplacement.get(variable))) {
                return Integer.parseInt(variableReplacement.get(variable)) != Integer.parseInt(value);
            } else {
                return (variableReplacement.get(variable).compareTo(value) != 0);
            }
        } else {
            throw new Exception("[NotEqualsCondition] Variable: " + variable + " does not have value assigned");
        }

    }

    @Override
    public void print() {
        System.out.println("Condition:{ " + "Type: NotEquals, " + "variable: " + this.variable + ", Value: " + this.value + ", variable: " + this.value + "}");

    }
}
