package org.softuni.mostwanted.services;

import org.softuni.mostwanted.domain.dtos.ExportRacingTown;
import org.softuni.mostwanted.domain.dtos.ImportTownDto;
import org.softuni.mostwanted.domain.entities.Town;

import java.util.List;

public interface TownService {
    void create(ImportTownDto dto);

    Town findOneByName(String name);

    List<ExportRacingTown> exportsRacingTowns();
}
