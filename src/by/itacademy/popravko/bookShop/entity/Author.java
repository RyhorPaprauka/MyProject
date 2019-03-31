package by.itacademy.popravko.bookShop.entity;

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
public class Author {

    private Long id;
    private String firstName;
    private String lastName;
    private String bio;
    @Builder.Default
    Set<Book> books = new HashSet<>();
}
