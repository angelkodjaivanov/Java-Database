package app;

import app.model.enums.Size;
import app.model.ingredients.BasicIngredient;
import app.model.ingredients.Ingredient;
import app.model.repositories.IngredientRepository;
import app.model.repositories.ShampooRepository;
import app.model.shampoos.BasicShampoo;
import app.model.shampoos.Shampoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import static app.model.repositories.ShampooRepository.*;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
@Component
class ConsoleRunner implements CommandLineRunner{

    @Autowired
    ShampooRepository shampooRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    @Override
    public void run(String... strings) throws Exception {
        Scanner scanner = new Scanner(System.in);

        BigDecimal price = scanner.nextBigDecimal();

        Integer count = ingredientRepository.countAllByPriceIsLessThan(price);

        System.out.println(count);
    }
}
