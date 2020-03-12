package com.api.restservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * Created with Intellij IDEA.
 * Author: Zhihai
 * Date: 2020-03-12 19:40
 * Email: xianzhihai@gmail.com
 * Description:
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {

    private Long id;
    private String quote;

    public Value() {
    }

    public Long getId() {
        return this.id;
    }

    public String getQuote() {
        return this.quote;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "Value{" +
                "id=" + id +
                ", quote='" + quote + '\'' +
                '}';
    }
}
