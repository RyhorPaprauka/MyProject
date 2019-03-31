package by.itacademy.popravko.bookShop.dao;

import by.itacademy.popravko.bookShop.connection.ConnectionPool;
import by.itacademy.popravko.bookShop.entity.Enum.OrderIsCompleted;
import by.itacademy.popravko.bookShop.entity.Enum.OrderStatus;
import by.itacademy.popravko.bookShop.entity.Order;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderDao {

    private static final OrderDao INSTANCE = new OrderDao();

    private static final String GET_ORDERS_BY_USER_ID = "SELECT * FROM book_store_storage.order WHERE user_id = ?";

    public List<Order> getUserOrders (Long userId){
        List<Order>orders = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ORDERS_BY_USER_ID);
            while (resultSet.next()) {
                Order order = getOrderFromResultSet(resultSet);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    private Order getOrderFromResultSet(ResultSet resultSet) throws SQLException {
        return Order.builder()
                .id(resultSet.getLong("id"))
                .userId(resultSet.getLong("user_id"))
                .localDate(resultSet.getDate("date").toLocalDate())
                .orderStatus(OrderStatus.valueOf(resultSet.getString("status")))
                .orderIsCompleted(OrderIsCompleted.valueOf(resultSet.getString("is_completed")))
                .build();
    }

    public static OrderDao getInstance() {
        return INSTANCE;
    }
}
