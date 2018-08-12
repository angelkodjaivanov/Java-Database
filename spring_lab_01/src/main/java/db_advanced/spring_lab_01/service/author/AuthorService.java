package db_advanced.spring_lab_01.service.author;

import db_advanced.spring_lab_01.model.Author;
import db_advanced.spring_lab_01.model.Book;

import java.util.List;

public interface AuthorService {
    void save(Author author);

    List<Author> getAllAuthors();
}
