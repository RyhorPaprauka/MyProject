package by.itacademy.popravko.bookShop.entity.Enum;

import lombok.Getter;

@Getter
public enum OrderIsCompleted {

    NON_COMPLETED("Не обработан"),
    COMPLETED("Обработан");

    private String description;

    OrderIsCompleted(String description) {
        this.description = description;
    }
}
