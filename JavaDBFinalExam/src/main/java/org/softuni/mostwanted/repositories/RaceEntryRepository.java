package org.softuni.mostwanted.repositories;

import org.softuni.mostwanted.domain.entities.Car;
import org.softuni.mostwanted.domain.entities.Race;
import org.softuni.mostwanted.domain.entities.RaceEntry;
import org.softuni.mostwanted.domain.entities.Racer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RaceEntryRepository extends JpaRepository<RaceEntry, Integer> {

    RaceEntry findOneByRacerAndCar(Racer racer , Car car);

    List<RaceEntry> findByRacer(Racer racer);

}
