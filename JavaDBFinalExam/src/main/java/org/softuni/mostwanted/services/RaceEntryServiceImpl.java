package org.softuni.mostwanted.services;

import org.softuni.mostwanted.domain.dtos.ImportRaceEntries;
import org.softuni.mostwanted.domain.entities.Car;
import org.softuni.mostwanted.domain.entities.RaceEntry;
import org.softuni.mostwanted.domain.entities.Racer;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repositories.CarRepository;
import org.softuni.mostwanted.repositories.RaceEntryRepository;
import org.softuni.mostwanted.repositories.RacerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RaceEntryServiceImpl implements RaceEntryService {

    private final RaceEntryRepository raceEntryRepository;
    private final ModelParser parser;
    private final CarRepository carRepository;
    private final RacerRepository racerRepository;

    @Autowired
    public RaceEntryServiceImpl(RaceEntryRepository
                                        raceEntryRepository, ModelParser parser, CarRepository carRepository, RacerRepository racerRepository) {
        this.raceEntryRepository = raceEntryRepository;
        this.parser = parser;
        this.carRepository = carRepository;
        this.racerRepository = racerRepository;
    }

    @Override
    public void save(ImportRaceEntries dto) {
        RaceEntry raceEntry = new RaceEntry();
        Car car = this.carRepository.findOne(dto.getCarId());
        Racer racer = this.racerRepository.findOneByName(dto.getRacer());
        raceEntry.setFinishTime(dto.getFinishTime());
        raceEntry.setHasFinished(dto.getHasFinished());
        raceEntry.setCar(car);
        raceEntry.setRacer(racer);
        this.raceEntryRepository.saveAndFlush(raceEntry);
    }

    @Override
    public RaceEntry findOneByRacerNameAndCarId(String name, Integer id) {
        Car car = this.carRepository.findOne(id);
        Racer racer = this.racerRepository.findOneByName(name);

        RaceEntry raceEntry = this.raceEntryRepository.findOneByRacerAndCar(racer, car);
        return raceEntry;
    }
}
