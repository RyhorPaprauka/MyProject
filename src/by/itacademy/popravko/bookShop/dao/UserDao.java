package by.itacademy.popravko.bookShop.dao;

import by.itacademy.popravko.bookShop.connection.ConnectionPool;
import by.itacademy.popravko.bookShop.entity.Enum.UserRole;
import by.itacademy.popravko.bookShop.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDao {

    private static final UserDao INSTANCE = new UserDao();

    private static final String SAVE =
            "INSERT INTO  shop_storage.user  (login, password, real_name, mail, address, phone, role)" +
                    " VALUES (?,?,?,?,?,?,?)";
    private static final String FIND_ALL = "SELECT * FROM shop_storage.user";
    private static final String FIND_BY_ID = FIND_ALL + " WHERE id=?";
    private static final String FIND_BY_LOGIN_PASSWORD = FIND_ALL + " WHERE login=? AND password =?";

    public User save(User user){

        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRealName());
            preparedStatement.setString(4, user.getMail());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setString(6, user.getPhone());
            preparedStatement.setString(7, user.getUserRole().name());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getLong("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }


    public Optional<User> findById(Long userId) {
        Optional<User> user = Optional.empty();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setLong(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = Optional.of(getUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public Optional<User> findByLoginPassword(String username, String password) {
        Optional<User> user = Optional.empty();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_LOGIN_PASSWORD)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = Optional.of(getUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        return User.builder()
                .id(resultSet.getLong("id"))
                .login(resultSet.getString("login"))
                .password(resultSet.getString("password"))
                .realName(resultSet.getString("real_name"))
                .mail(resultSet.getString("mail"))
                .address(resultSet.getString("address"))
                .phone(resultSet.getString("phone"))
                .userRole(UserRole.valueOf(resultSet.getString("role")))
                .build();
        /*user.getOrders().addAll(OrderDao.getInstance().getUserOrders(user.getId()));
        user.getComments().addAll(CommentDao.getInstance().getUserComments(user.getId()));*/
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
}
