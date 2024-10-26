package org.pal.dao;

import org.pal.models.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CreateOrderDao {

    private final JdbcTemplate jdbcTemplate;

    public CreateOrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertOrders(List<Order> orders) {
        System.out.println("Order insertion started");
        String sql = "INSERT INTO orders (order_id, user_id, product_id, quantity, order_date) VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Order order = orders.get(i);
                ps.setString(1, order.getOrder_id());
                ps.setString(2, order.getUser_id());
                ps.setString(3, order.getProduct_id());
                ps.setString(4, order.getQuantity());
                ps.setObject(5, order.getOrder_date());  // Assuming order_date is of type LocalDateTime
            }

            @Override
            public int getBatchSize() {
                System.out.println("Inserted Batch Size: " + orders.size());
                return orders.size();
            }
        });
    }
}
