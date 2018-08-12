package org.softuni.mostwanted.repositories;

import org.softuni.mostwanted.domain.entities.District;
import org.softuni.mostwanted.domain.entities.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRepository extends JpaRepository<Race, Integer> {
    Race findOneByDistrictAndLaps(District district, Integer laps);
}
