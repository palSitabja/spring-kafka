package org.pal.controllers;

import org.pal.models.Order;
import org.pal.services.OrderProducerService;
import org.pal.utils.OrderGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

import static org.pal.utils.OrderGeneratorUtil.bulkGenerateOrder;

@RestController("/api/v1")
public class OrderController {
    OrderProducerService orderProducerService;
    @Autowired
    public OrderController(OrderProducerService orderProducerService) {
        this.orderProducerService = orderProducerService;
    }

    @GetMapping("/publish-order/{count}")
    public ResponseEntity<String> publishOrder(@PathVariable int count) {
        Set<Order> orders = OrderGeneratorUtil.bulkGenerateOrder(count);
        orders.forEach(order -> orderProducerService.sendOrder(order));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
