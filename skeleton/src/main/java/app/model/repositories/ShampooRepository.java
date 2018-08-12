package app.model.repositories;

import app.model.enums.Size;
import app.model.shampoos.BasicShampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<BasicShampoo, Long> {

    List<BasicShampoo> getAllBySizeOrderById(Size size);

    List<BasicShampoo> getAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);


}
