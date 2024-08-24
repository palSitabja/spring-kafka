package org.pal.utils;

import org.pal.models.Order;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class OrderGeneratorUtil {
    public static Set<Order> bulkGenerateOrder(int orderCount) {
        Set<Order> orders = new HashSet<>();
        for (int i = 0; i < orderCount; i++) {
            Order order = generateOrder();
            orders.add(order);
        }
        return orders;
    }

    public static Order generateOrder() {
        Order order = new Order();
        order.setOrder_id(UUID.randomUUID().toString());
        order.setQuantity(String.valueOf((new Random().nextInt(10000-100) + 100)));
        order.setProduct_id(UUID.randomUUID().toString());
        order.setUser_id(UUID.randomUUID().toString());
        order.setOrder_date(LocalDateTime.now());

        return order;
    }
}
