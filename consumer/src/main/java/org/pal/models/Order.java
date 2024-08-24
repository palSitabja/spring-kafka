package org.pal.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {
    private String order_id;
    private String user_id;
    private String product_id;
    private String quantity;
    private LocalDateTime order_date;
}
