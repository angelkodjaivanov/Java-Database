package db_advanced.spring_lab_01;

import db_advanced.spring_lab_01.model.Author;
import db_advanced.spring_lab_01.model.Book;
import db_advanced.spring_lab_01.model.Category;
import db_advanced.spring_lab_01.model.enums.AgeRestriction;
import db_advanced.spring_lab_01.model.enums.EditionType;
import db_advanced.spring_lab_01.service.author.AuthorService;
import db_advanced.spring_lab_01.service.book.BookService;
import db_advanced.spring_lab_01.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class SpringLab01Application {

	public static void main(String[] args) {
	    SpringApplication.run(SpringLab01Application.class, args);
	}
}

@Component
class ConsoleRunner implements CommandLineRunner{

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BookService bookService;

    @Override
    public void run(String... strings) throws Exception {

        BufferedReader authorsReader = new BufferedReader(new FileReader("C:\\Users\\AgiKo\\Desktop" +
                "\\Programing\\Exam\\Skeletons\\spring_lab_01\\src\\main\\resources\\authors.txt"));
        String authorsLine = authorsReader.readLine();
        while((authorsLine = authorsReader.readLine()) != null) {
            String[] data = authorsLine.split("\\s+");
            String firstName = data[0];
            String lastName = data[1];

            Author author = new Author();
            author.setFirstName(firstName);
            author.setLastName(lastName);

            authorService.save(author);
        }

        BufferedReader categoriesReader = new BufferedReader(new FileReader("C:\\Users\\AgiKo\\Desktop" +
                "\\Programing\\Exam\\Skeletons\\spring_lab_01\\src\\main\\resources\\categories.txt"));
        String categoriesLine = categoriesReader.readLine();
        while((categoriesLine = categoriesReader.readLine()) != null) {
            String[] data = categoriesLine.split("\\s+");
            String name = data[0];

            Category category = new Category(name);
            categoryService.save(category);
        }

        List<Author> authors = authorService.getAllAuthors();
        List<Category> categories = categoryService.getAllCategories();

        BufferedReader booksReader = new BufferedReader(new FileReader("C:\\Users\\AgiKo\\Desktop" +
                "\\Programing\\Exam\\Skeletons\\spring_lab_01\\src\\main\\resources\\books.txt"));
        String booksLine = booksReader.readLine();
        while((booksLine = booksReader.readLine()) != null) {
            String[] data = booksLine.split("\\s+");

            Random random = new Random();

            int authorIndex = random.nextInt(authors.size());
            Author author = authors.get(authorIndex);
            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
            Date releaseDate = formatter.parse(data[1]);
            int copies = Integer.parseInt(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
            StringBuilder titleBuilder = new StringBuilder();
            for (int i = 5; i < data.length; i++) {
                titleBuilder.append(data[i]).append(" ");
            }
            titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(" "));
            String title = titleBuilder.toString();

            Book book = new Book();
            book.setAuthor(author);
            book.setEditionType(editionType);
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);

            int categoryIndex = random.nextInt(categories.size());
            List<Category> categoryList = new ArrayList<>();
            Category category = categories.get(categoryIndex);
            categoryList.add(category);

            book.setCategories(categoryList);

            bookService.save(book);
        }

        /*
        List<Book> books = bookService.booksByGeorgePowell();

        for (Book book:books
                ) {
            System.out.println(book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName() + " - " +
                book.getTitle() + " : " + book.getReleaseDate() + " || " + book.getAgeRestriction());
        }
        */
    }
}
