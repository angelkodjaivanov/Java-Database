package dbadvanced.mapping.repository;

import dbadvanced.mapping.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
}
