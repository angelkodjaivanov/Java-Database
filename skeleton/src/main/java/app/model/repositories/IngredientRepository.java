package app.model.repositories;

import app.model.ingredients.BasicIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<BasicIngredient, Long>{

    List<BasicIngredient> getAllByNameStartingWith(String letter);

    Integer countAllByPriceIsLessThan(BigDecimal price);
}
