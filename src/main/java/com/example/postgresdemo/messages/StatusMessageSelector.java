package com.example.postgresdemo.messages;

import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

/**
 * User: ankoks
 * Date: 23/07/2019
 */
public class StatusMessageSelector implements MessageSelector {
    private String guid;

    public StatusMessageSelector(String guid) {
        this.guid = guid;
    }

    @Override
    public boolean accept(Message<?> message) {
        MessageHeaders headers = message.getHeaders();

        headers.get(Channels.HeaderAttributes.GUID);
        String guidFromHeader = headers.get(Channels.HeaderAttributes.GUID).toString();

        return !guid.equalsIgnoreCase(guidFromHeader);
    }
}
