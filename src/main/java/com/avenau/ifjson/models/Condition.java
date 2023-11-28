package com.avenau.ifjson.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.HashMap;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AndCondition.class, name = "AND"),
        @JsonSubTypes.Type(value = GreaterThanCondition.class, name = "GreaterThan")
})
public interface Condition {

    public Boolean evaluate(HashMap<String,String> variableReplacement) throws Exception;
    public void print();

}
