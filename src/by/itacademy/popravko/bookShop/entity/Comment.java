package by.itacademy.popravko.bookShop.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {

    private Long id;
    private Long userId;
    private Long bookId;
    private String text;
}
