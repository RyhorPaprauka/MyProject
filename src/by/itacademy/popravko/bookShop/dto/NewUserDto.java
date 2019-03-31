package by.itacademy.popravko.bookShop.dto;

import by.itacademy.popravko.bookShop.entity.Enum.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewUserDto {

    private String login;
    private String password;
    private String realName;
    private String mail;
    private String address;
    private String phone;

}
