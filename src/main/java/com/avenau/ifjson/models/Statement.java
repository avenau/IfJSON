package com.avenau.ifjson.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.HashMap;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ResultStatement.class, name = "ResultStatement"),
        @JsonSubTypes.Type(value = IfStatement.class, name = "IfStatement")
})
public interface Statement {




    public String evaluate(HashMap<String, String> variableReplacements) throws Exception;

    public void print();
}
