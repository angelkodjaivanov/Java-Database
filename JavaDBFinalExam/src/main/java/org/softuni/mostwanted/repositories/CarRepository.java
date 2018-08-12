package org.softuni.mostwanted.repositories;

import org.softuni.mostwanted.domain.entities.Car;
import org.softuni.mostwanted.domain.entities.Race;
import org.softuni.mostwanted.domain.entities.Racer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{
    Car findOneByBrandAndModelAndYearOfProductionAndRacer(String brand, String model,
                                                          Integer yearOfProduction, Racer racer);

    List<Car> findByRacer(Racer racer);
}
