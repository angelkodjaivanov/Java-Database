package org.softuni.mostwanted.services;

import org.softuni.mostwanted.domain.dtos.ImportRacesDto;
import org.softuni.mostwanted.domain.entities.Race;

public interface RaceService {
    void save(ImportRacesDto dto);

    Race findOneByDistrictNameAndLaps(String name, Integer laps);
}
