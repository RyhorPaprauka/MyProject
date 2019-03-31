package by.itacademy.popravko.bookShop.service;

import by.itacademy.popravko.bookShop.dao.UserDao;
import by.itacademy.popravko.bookShop.dto.NewUserDto;
import by.itacademy.popravko.bookShop.entity.Enum.UserRole;
import by.itacademy.popravko.bookShop.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

    private static final UserService INSTANCE = new UserService();

    public void registration(NewUserDto dto) {
        User newUser = UserDao.getInstance().save(
                User.builder()
                        .login(dto.getLogin())
                        .password(dto.getPassword())
                        .realName(dto.getRealName())
                        .mail(dto.getMail())
                        .address(dto.getAddress())
                        .phone(dto.getPhone())
                        .userRole(UserRole.CUSTOMER)
                        .build());
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
