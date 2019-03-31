package by.itacademy.popravko.bookShop.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlackList {

    private Long id;
    private User user;
    private String reason;
}
