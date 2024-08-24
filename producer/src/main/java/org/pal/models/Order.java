package org.pal.models;

import lombok.Data;

@Data
public class Order {
    private String order_id;
    private String user_id;
    private String product_id;
    private String quantity;
}
