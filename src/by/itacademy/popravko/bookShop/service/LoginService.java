package by.itacademy.popravko.bookShop.service;

import by.itacademy.popravko.bookShop.dao.UserDao;
import by.itacademy.popravko.bookShop.dto.LoginDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginService {

    private static final LoginService INSTANCE = new LoginService();

    public Optional<LoginDto> login(String username, String password) {
        return UserDao.getInstance().findByLoginPassword(username, password)
                .map(it -> LoginDto.builder()
                        .login(it.getLogin())
                        .password(it.getPassword())
                        .realName(it.getRealName())
                        .role(it.getUserRole())
                        .build());
    }

    public static LoginService getInstance() {
        return INSTANCE;
    }
}
