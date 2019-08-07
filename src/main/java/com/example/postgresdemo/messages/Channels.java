package com.example.postgresdemo.messages;

public interface Channels {
    interface HeaderAttributes {
        String GUID = "guid";
    }

    String PROCESSING_CHANNEL = "PROCESSING_CHANNEL";
    String SUCCESSES_CHANNEL = "SUCCESSES_CHANNEL";
    String ERROR_CHANNEL = "ERROR_CHANNEL";
}
