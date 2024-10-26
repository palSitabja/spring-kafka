package org.pal.services;

import org.pal.dao.CreateOrderDao;
import org.pal.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderConsumerService {

    CreateOrderDao createOrderDao;

    @Autowired
    OrderConsumerService(CreateOrderDao createOrderDao) {
        this.createOrderDao = createOrderDao;
    }

    int counter = 0;
    List<Order> orders = new ArrayList<>();
    @KafkaListener(topics = "orders", groupId = "order_consumer_group")
    public void listenGroup(Order message) {
        counter++;
        orders.add(message);
        //System.out.println("Received Message in group order_consumer_group: " + message);
        if (counter==1000) {
            createOrderDao.insertOrders(orders);
            orders.clear();
            counter = 0;
        }
    }
}
