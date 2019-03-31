package by.itacademy.popravko.bookShop.entity.Enum;

import lombok.Getter;

@Getter
public enum BookGenre {

    CLASSIC("Классика"),
    POETRY("Поэзия"),
    FANTASY("Фантастика"),
    DETECTIVE("Детектив"),
    SATIRE("Сатира"),
    EDUCATIONAL("Учебная литература"),
    KIDS("Детские книжки");

    private String description;

    BookGenre(String description) {
        this.description = description;
    }
}
