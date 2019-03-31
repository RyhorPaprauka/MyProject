package by.itacademy.popravko.bookShop.entity.Enum;

import lombok.Getter;

@Getter
public enum OrderStatus {

    PROCESSING("В процессе"),
    CONFIRMED("Подтвержден");

    private String description;

    OrderStatus(String description) {
        this.description = description;
    }
}
