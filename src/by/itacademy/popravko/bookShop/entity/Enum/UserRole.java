package by.itacademy.popravko.bookShop.entity.Enum;

import lombok.Getter;

@Getter
public enum UserRole {

    ADMIN("Администратор"),
    CUSTOMER("Клиент");

    private String description;

    UserRole(String description) {
        this.description = description;
    }
}
