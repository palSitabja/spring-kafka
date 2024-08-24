package org.pal.services;

import org.pal.models.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumerService {

    @KafkaListener(topics = "orders", groupId = "order_consumer_group")
    public void listenGroup(Order message) {
        System.out.println("Received Message in group foo: " + message);
    }
}
