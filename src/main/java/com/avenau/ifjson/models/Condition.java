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
        @JsonSubTypes.Type(value = OrCondition.class, name = "OR"),
        @JsonSubTypes.Type(value = GreaterThanCondition.class, name = "GreaterThan"),
        @JsonSubTypes.Type(value = LessThanCondition.class, name = "LessThan"),
        @JsonSubTypes.Type(value = EqualsCondition.class, name = "Equals"),
        @JsonSubTypes.Type(value = NotEqualsCondition.class, name = "NotEquals")
})
public interface Condition {

    public Boolean evaluate(HashMap<String,String> variableReplacement) throws Exception;
    public void print();

}
