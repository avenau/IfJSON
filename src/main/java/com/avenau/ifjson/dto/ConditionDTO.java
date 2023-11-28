package com.avenau.ifjson.dto;


import com.avenau.ifjson.models.AndCondition;
import com.avenau.ifjson.models.GreaterThan;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AndConditionDTO.class, name = "AND"),
        @JsonSubTypes.Type(value = GreaterThanDTO.class, name = "GreaterThan")
})
public interface ConditionDTO {

    public void print();

}
