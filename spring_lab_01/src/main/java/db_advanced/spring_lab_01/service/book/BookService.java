package db_advanced.spring_lab_01.service.book;

import db_advanced.spring_lab_01.model.Book;
import java.util.List;

public interface BookService {
    void save(Book book);

    List<Book> findAllBookAfterSpecificYear();

    List<Book> booksByGeorgePowell();
}
