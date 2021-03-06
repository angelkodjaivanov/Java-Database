package app.retake.repositories;

import app.retake.domain.dto.AnimalsJSONExportDTO;
import app.retake.domain.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.PrePersist;
import javax.validation.constraints.Pattern;
import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer>{
    Animal findOneByPassportSerialNumber(String passportSerialNumber);

    @Query(value = "SELECT new app.retake.domain.dto.AnimalsJSONExportDTO" +
            "(p.ownerName, a.name, a.age, p.serialNumber, p.registrationDate) " +
            "FROM Animal AS a left JOIN a.passport As p where p.ownerPhoneNumber=:ownerNumber")
    List<AnimalsJSONExportDTO> allAnimalsByOwnerPhoneNumber(@Param("ownerNumber") String phoneNumber);
}
