package org.softuni.mostwanted.services;

import org.softuni.mostwanted.domain.dtos.ImportRacesDto;
import org.softuni.mostwanted.domain.entities.District;
import org.softuni.mostwanted.domain.entities.Race;
import org.softuni.mostwanted.domain.entities.RaceEntry;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repositories.DistrictRepository;
import org.softuni.mostwanted.repositories.RaceEntryRepository;
import org.softuni.mostwanted.repositories.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class RaceServiceImpl implements RaceService {

    private final RaceRepository raceRepository;
    private final ModelParser parser;
    private final DistrictRepository districtRepository;
    private final RaceEntryRepository raceEntryRepository;

    @Autowired
    public RaceServiceImpl(RaceRepository raceRepository, ModelParser parser,
                           DistrictRepository districtRepository, RaceEntryRepository raceEntryRepository) {
        this.raceRepository = raceRepository;
        this.parser = parser;
        this.districtRepository = districtRepository;
        this.raceEntryRepository = raceEntryRepository;
    }

    @Override
    public void save(ImportRacesDto dto) {
        Race race = new Race();
        Set<RaceEntry> entrySet = dto.getEntries().stream().map(a -> {
           RaceEntry raceEntry = this.raceEntryRepository.findOne(a.getId());
           return raceEntry;
        }).collect(Collectors.toSet());
        District district = this.districtRepository.findOneByName(dto.getDistrictName());
        race.setLaps(dto.getLaps());
        race.setDistrict(district);
        race.setEntries(entrySet);
        this.raceRepository.saveAndFlush(race);
    }

    @Override
    public Race findOneByDistrictNameAndLaps(String name, Integer laps) {
        District district = this.districtRepository.findOneByName(name);

        Race race = this.raceRepository.findOneByDistrictAndLaps(district, laps);
        return race;
    }
}
