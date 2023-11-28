package com.avenau.ifjson.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AndCondition.class, name = "AND"),
        @JsonSubTypes.Type(value = GreaterThan.class, name = "GreaterThan")
})
public interface Condition {

    public Boolean evaluate();
    public void print();
}
