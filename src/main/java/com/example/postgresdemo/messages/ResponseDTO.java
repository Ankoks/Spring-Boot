package com.example.postgresdemo.messages;

/**
 * User: ankoks
 * Date: 23/07/2019
 */
public class ResponseDTO {
    private String guid;
    private Integer value;

    public ResponseDTO(String guid, Integer value) {
        this.guid = guid;
        this.value = value;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
