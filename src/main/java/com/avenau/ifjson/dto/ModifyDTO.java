package com.avenau.ifjson.dto;

import com.avenau.ifjson.models.IfConditionWrapper;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ModifyDTO {

    @JsonProperty("oldCondition")
    private IfConditionWrapper oldCondition;
    @JsonProperty("newCondition")
    private IfConditionWrapper newCondition;

    public ModifyDTO () {
    }

    public ModifyDTO (IfConditionWrapper oldCondition, IfConditionWrapper newCondition){
        this.oldCondition = oldCondition;
        this.newCondition = newCondition;
    }

    public IfConditionWrapper getNewCondition() {
        return newCondition;
    }

    public IfConditionWrapper getOldCondition() {
        return oldCondition;
    }
}
