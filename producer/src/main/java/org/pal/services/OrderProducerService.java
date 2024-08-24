package org.pal.services;

import org.pal.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducerService {
    KafkaTemplate<String, Order> kafkaTemplate;

    @Autowired
    public OrderProducerService(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(Order order) {
        kafkaTemplate.send("spring-kafka-test-topic",order.getOrder_id(), order)
                .whenComplete((record, ex) -> {
                    if (ex == null) {
                        System.out.println("Order sent successfully");
                        System.out.printf("Order: %s%n Result: %s%n", order, record.getProducerRecord());
                    } else {
                        System.out.println("Unable to send message=[" +
                                ex + "] due to : " + ex.getMessage());
                    }
                });
    }
}
