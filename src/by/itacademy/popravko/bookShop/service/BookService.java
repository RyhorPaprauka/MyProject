package by.itacademy.popravko.bookShop.service;

import by.itacademy.popravko.bookShop.dao.BookDao;
import by.itacademy.popravko.bookShop.entity.Book;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookService {

    private static final BookService INSTANCE = new BookService();

    public List<Book> findAll() {
        return BookDao.getInstance().findAll();
    }

    public Book findById(Long id) {
        return BookDao.getInstance().findById(id).orElse(null);
    }

    public static BookService getInstance() {
        return INSTANCE;
    }
}
