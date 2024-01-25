package org.uengine.process.messaging;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(Processor.class)
public class ProcessMessageHandler {

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public String handleMessage(String message) {
        // Process the message and return a response
        return "Processed: " + message;
    }
}