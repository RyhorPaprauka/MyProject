package by.itacademy.popravko.bookShop.dao;

import by.itacademy.popravko.bookShop.connection.ConnectionPool;
import by.itacademy.popravko.bookShop.entity.Comment;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentDao {

    private static final CommentDao INSTANCE = new CommentDao();

    private static final String GET_COMMENTS_BY_USER_ID =
            "SELECT * FROM book_store_storage.comment WHERE user_id = ?";

    public List<Comment> getUserComments (Long userId){
        List<Comment>comments = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_COMMENTS_BY_USER_ID);
            while (resultSet.next()) {
                Comment order = getCommentFromResultSet(resultSet);
                comments.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comments;
    }

    private Comment getCommentFromResultSet(ResultSet resultSet) throws SQLException {
        return Comment.builder()
                .id(resultSet.getLong("id"))
                .userId(resultSet.getLong("user_id"))
                .bookId(resultSet.getLong("book_id"))
                .text(resultSet.getString("text"))
                .build();
    }

    public static CommentDao getInstance() {
        return INSTANCE;
    }
}
