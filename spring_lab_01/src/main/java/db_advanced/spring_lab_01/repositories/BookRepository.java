package db_advanced.spring_lab_01.repositories;

import db_advanced.spring_lab_01.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book>  findAllByAuthorFirstNameAndAuthorLastNameOrderByAgeRestrictionDescTitleAsc(String firstName, String lastName);
}
