package by.itacademy.popravko.bookShop.dao;

import by.itacademy.popravko.bookShop.connection.ConnectionPool;
import by.itacademy.popravko.bookShop.entity.Book;
import by.itacademy.popravko.bookShop.entity.Enum.BookGenre;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookDao {

    private static final BookDao INSTANCE = new BookDao();

    private static final String FIND_ALL = "SELECT * FROM shop_storage.book";
    private static final String FIND_BY_ID = FIND_ALL + " WHERE id=?";

    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()) {
                Book book = getBookFromResultSet(resultSet);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public Optional<Book> findById(Long id) {
        Optional<Book> book = Optional.empty();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                book = Optional.of(getBookFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }

    private Book getBookFromResultSet(ResultSet resultSet) throws SQLException {
        return Book.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .img(resultSet.getString("img_link"))
                .bookGenre(BookGenre.valueOf(resultSet.getString("genre")))
                .price(resultSet.getInt("price"))
                .quantity(resultSet.getInt("quantity"))
                .build();
                /*book.getAuthors().addAll(AuthorDao.getInstance().getBookAuthor(book.getId()));
        book.getComments().addAll(CommentDao.getInstance().getBookComments(book.getId()));*/
    }

    public static BookDao getInstance() {
        return INSTANCE;
    }
}
