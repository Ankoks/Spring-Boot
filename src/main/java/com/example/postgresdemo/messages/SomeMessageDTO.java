package com.example.postgresdemo.messages;

/**
 * User: ankoks
 * Date: 23/07/2019
 */
public class SomeMessageDTO {
    private String name;
    private Integer value;

    public SomeMessageDTO(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
