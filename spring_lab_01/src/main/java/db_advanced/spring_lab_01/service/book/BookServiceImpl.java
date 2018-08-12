package db_advanced.spring_lab_01.service.book;

import db_advanced.spring_lab_01.model.Author;
import db_advanced.spring_lab_01.model.Book;
import db_advanced.spring_lab_01.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public void save(Book book) {
        this.bookRepository.save(book);
    }

    @Override
    public List<Book> findAllBookAfterSpecificYear() {
        List<Book> books = this.bookRepository.findAll();

        for(int i = 0; i < books.size(); i++){
            LocalDate localDate = books.get(i).getReleaseDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            int year = localDate.getYear();

            if(year <= 2000){
                books.remove(i);
            }
        }

        return books;

    }

    @Override
    public List<Book> booksByGeorgePowell() {
        return this.bookRepository.findAllByAuthorFirstNameAndAuthorLastNameOrderByAgeRestrictionDescTitleAsc(
          "George", "Powell"
        );
    }
}
