package com.api.restservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created with Intellij IDEA.
 * Author: Zhihai
 * Date: 2020-03-12 19:41
 * Email: xianzhihai@gmail.com
 * Description: Assume the third party API returns data model structure declared as Quote
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    private String type;
    private Value value;
    private Error error;

    public Quote() {
    }

    public Quote(String type, Error error){
        this.type = type;
        this.error = error;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}