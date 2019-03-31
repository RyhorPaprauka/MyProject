package by.itacademy.popravko.bookShop.entity;

import by.itacademy.popravko.bookShop.entity.Enum.BookGenre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    private Long id;
    private String name;
    private String img;
    private BookGenre bookGenre;
    private Integer price;
    private Integer quantity;
    @Builder.Default
    Set<Author> authors = new HashSet<>();
    @Builder.Default
    Set<Comment> comments = new HashSet<>();
}
