package com.avenau.ifjson.dto;

import com.avenau.ifjson.models.Condition;
import com.fasterxml.jackson.annotation.JsonProperty;

public class IfConditionDTO {

    @JsonProperty("condition")
    private ConditionDTO condition;

    public IfConditionDTO(){
    }

    public IfConditionDTO(ConditionDTO condition){
        this.condition = condition;
    }

    public ConditionDTO getCondition(){
        return this.condition;
    }
    public void print(){
        System.out.println("====== Printing IfConditionDTO ============");
        this.condition.print();
        System.out.println("====== ======================= ============");
    }
}
