package org.softuni.mostwanted.services;

import org.softuni.mostwanted.domain.dtos.ExportMostWanted;
import org.softuni.mostwanted.domain.dtos.ExportRacersDto;
import org.softuni.mostwanted.domain.dtos.RacerImportDto;
import org.softuni.mostwanted.domain.entities.Racer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface RacerService {
    void save(RacerImportDto dto);

    Racer findOneById(Integer id);

    Racer findOneByName(String name);

    List<ExportRacersDto> exportRacers();

    ExportMostWanted ExportMostWanted();
}
