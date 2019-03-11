package com.example.postgresdemo.exception;

/**
 * User: ankoks
 * Date: 11/03/2019
 */
public class ExceptionFrontEnd {
    private String frontEndMessage;
    private String backEndMessage;

    public ExceptionFrontEnd(String frontEndMessage, String backEndMessage) {
        this.frontEndMessage = frontEndMessage;
        this.backEndMessage = backEndMessage;
    }

    public String getFrontEndMessage() {
        return frontEndMessage;
    }

    public void setFrontEndMessage(String frontEndMessage) {
        this.frontEndMessage = frontEndMessage;
    }

    public String getBackEndMessage() {
        return backEndMessage;
    }

    public void setBackEndMessage(String backEndMessage) {
        this.backEndMessage = backEndMessage;
    }
}
