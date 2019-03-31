package by.itacademy.popravko.bookShop.entity;

import by.itacademy.popravko.bookShop.entity.Enum.UserRole;
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
public class User {

    private Long id;
    private String login;
    private String password;
    private String realName;
    private String mail;
    private String address;
    private String phone;
    private UserRole userRole;
    @Builder.Default
    Set<Order> orders = new HashSet<>();
    @Builder.Default
    Set<Comment> comments = new HashSet<>();
}
