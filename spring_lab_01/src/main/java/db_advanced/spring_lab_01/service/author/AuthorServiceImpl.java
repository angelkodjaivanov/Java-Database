package db_advanced.spring_lab_01.service.author;

import db_advanced.spring_lab_01.model.Author;
import db_advanced.spring_lab_01.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void save(Author author) {
        this.authorRepository.save(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return this.authorRepository.findAll();
    }
}
