package dbadvanced.mapping.repository;

import dbadvanced.mapping.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {
}
