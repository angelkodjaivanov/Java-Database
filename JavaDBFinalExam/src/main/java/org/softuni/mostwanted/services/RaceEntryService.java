package org.softuni.mostwanted.services;

import org.softuni.mostwanted.domain.dtos.ImportRaceEntries;
import org.softuni.mostwanted.domain.entities.RaceEntry;

public interface RaceEntryService {
    void save(ImportRaceEntries dto);

    RaceEntry findOneByRacerNameAndCarId(String name, Integer id);
}
