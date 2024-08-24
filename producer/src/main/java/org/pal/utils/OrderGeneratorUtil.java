package org.pal.utils;

import org.pal.models.Order;

import java.util.*;

public class OrderGeneratorUtil {
    public static Set<Order> bulkGenerateOrder(int orderCount) {
        Set<Order> orders = new HashSet<>();
        for (int i = 0; i < orderCount; i++) {
            Order order = new Order();
            order.setOrder_id(UUID.randomUUID().toString());
            order.setQuantity(String.valueOf((new Random().nextInt(10000-100) + 100)));
            order.setProduct_id(UUID.randomUUID().toString());
            order.setUser_id(UUID.randomUUID().toString());

            orders.add(order);
        }
        return orders;
    }
}
