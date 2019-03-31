package by.itacademy.popravko.bookShop.entity;

import by.itacademy.popravko.bookShop.entity.Enum.OrderIsCompleted;
import by.itacademy.popravko.bookShop.entity.Enum.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    private Long id;
    private Long userId;
    private LocalDate localDate;
    @Builder.Default
    Set<Book> books = new HashSet<>();
    private OrderStatus orderStatus;
    private OrderIsCompleted orderIsCompleted;
}
