package com.example.postgresdemo.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

/**
 * User: ankoks
 * Date: 23/07/2019
 */
@RestController
@RequestMapping(value = "/message")
public class MessageController {

    @Autowired
    @Qualifier(value = Channels.PROCESSING_CHANNEL)
    private MessageChannel messageChannel;

    @Autowired
    @Qualifier(value = Channels.SUCCESSES_CHANNEL)
    private QueueChannel successChannel;

    @Autowired
    @Qualifier(value = Channels.ERROR_CHANNEL)
    private QueueChannel errorChannel;

    @GetMapping(value = "/sendSomeMessage")
    public ResponseEntity<SomeMessageDTO> sendSomeMessage() {
        String uuid = UUID.randomUUID().toString();
        SomeMessageDTO someMessageDTO = new SomeMessageDTO(uuid, new Random().nextInt());

        Map<String, Object> headers = new HashMap<>();
        headers.put(Channels.HeaderAttributes.GUID, uuid);

        Message<SomeMessageDTO> message = MessageBuilder.withPayload(someMessageDTO)
                .copyHeadersIfAbsent(headers)
                .build();

        messageChannel.send(message);

        return ResponseEntity.ok(someMessageDTO);
    }

    @GetMapping(value = "/checkSomeMessage/{guid}")
    public void checkSomeMessage(@PathVariable("guid") String guid) {
        int errorSize = errorChannel.getQueueSize();
        int successSize = successChannel.getQueueSize();

        List<Message<?>> success = successChannel.purge(new StatusMessageSelector(guid));
        List<Message<?>> error = errorChannel.purge(new StatusMessageSelector(guid));

        System.out.println("successSize = [" + successSize + "], errorSize = [" + errorSize + "]");
    }

    @ServiceActivator(inputChannel = Channels.PROCESSING_CHANNEL, outputChannel = Channels.SUCCESSES_CHANNEL,
            async = "process",
            poller = @Poller(
                    taskExecutor = "msgExecutor",
                    maxMessagesPerPoll = "1",
                    errorChannel = Channels.ERROR_CHANNEL
            )
    )
    public Message<ResponseDTO> process(Message<SomeMessageDTO> message) {
        System.out.println("Activate: " + Channels.PROCESSING_CHANNEL);

        MessageHeaders headers = message.getHeaders();
        Optional<String> guidFromHeader = Optional.of((String) headers.get(Channels.HeaderAttributes.GUID));

        SomeMessageDTO payload = message.getPayload();

        Map<String, Object> headerEntry = new HashMap<>();
        headerEntry.put(Channels.HeaderAttributes.GUID, guidFromHeader.orElse(null));

        MessageHeaders responseHeaders = new MessageHeaders(headerEntry);

        return MessageBuilder.withPayload(new ResponseDTO(payload.getName(), payload.getValue()))
                .copyHeadersIfAbsent(responseHeaders)
                .build();
    }
}
