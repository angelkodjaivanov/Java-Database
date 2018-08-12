package org.softuni.mostwanted.services;

import org.softuni.mostwanted.domain.dtos.*;
import org.softuni.mostwanted.domain.entities.Car;
import org.softuni.mostwanted.domain.entities.RaceEntry;
import org.softuni.mostwanted.domain.entities.Racer;
import org.softuni.mostwanted.domain.entities.Town;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repositories.CarRepository;
import org.softuni.mostwanted.repositories.RaceEntryRepository;
import org.softuni.mostwanted.repositories.RacerRepository;
import org.softuni.mostwanted.repositories.TownRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class RacerServiceImpl implements RacerService {

    private final RacerRepository racerRepository;
    private final ModelParser parser;
    private final TownRepository townRepository;
    private final CarRepository carRepository;
    private final RaceEntryRepository raceEntryRepository;

    public RacerServiceImpl(RacerRepository racerRepository, ModelParser parser, TownRepository townRepository, CarRepository carRepository, RaceEntryRepository raceEntryRepository) {
        this.racerRepository = racerRepository;
        this.parser = parser;
        this.townRepository = townRepository;
        this.carRepository = carRepository;
        this.raceEntryRepository = raceEntryRepository;
    }

    @Override
    public void save(RacerImportDto dto) {
        Town town = this.townRepository.findOneByName(dto.getHomeTown());
        Racer racer = new Racer();
        racer.setName(dto.getName());
        racer.setAge(dto.getAge());
        racer.setBounty(dto.getBounty());
        racer.setHomeTown(town);
        this.racerRepository.saveAndFlush(racer);
    }

    @Override
    public Racer findOneById(Integer id) {
        Racer racer = this.racerRepository.findOne(id);
        return racer;
    }

    @Override
    public Racer findOneByName(String name) {
        Racer racer = this.racerRepository.findOneByName(name);
        return racer;
    }

    @Override
    public List<ExportRacersDto> exportRacers() {
        List<Racer> racers = this.racerRepository.findAll();
        List<ExportRacersDto> exportRacersDtos = new ArrayList<>();

        for (Racer racer:racers
             ) {
            List<String> carInformation = new ArrayList<>();
            List<Car> cars = this.carRepository.findByRacer(racer);
            for (Car car:cars
                 ) {
                String inf = car.getBrand() + " " + car.getModel() + " " + car.getYearOfProduction();
                carInformation.add(inf);
            }
            if(cars.size() > 0){
                ExportRacersDto exportRacersDto = new ExportRacersDto(racer.getName(), racer.getAge(), carInformation);
                exportRacersDtos.add(exportRacersDto);
            }
        }

        exportRacersDtos.sort(Comparator.comparing(ExportRacersDto::carsCount).reversed().
                thenComparing(ExportRacersDto::getName));

        return exportRacersDtos;
    }

    @Override
    public ExportMostWanted ExportMostWanted() {
        List<Racer> racers = this.racerRepository.findAll();

        int maxCount = 0;
        int racerId = 1;
        for (Racer racer:racers) {
            List<RaceEntry> raceEntries = this.raceEntryRepository.findByRacer(racer);
            int count = raceEntries.size();
            if(count > maxCount){
                maxCount = count;
                racerId = racer.getId();
            }
        }

        Racer racer = this.racerRepository.findOne(racerId);
        List<RaceEntry> raceEntries = this.raceEntryRepository.findByRacer(racer);
        List<ExportEntryDto> entries = new ArrayList<>();
        for (RaceEntry raceEntry:raceEntries) {
            String car = raceEntry.getCar().getBrand() + " " + raceEntry.getCar().getModel() + " @ " +
                    raceEntry.getCar().getYearOfProduction();
            ExportEntryDto exportEntryDto = new ExportEntryDto(raceEntry.getFinishTime(), car);
            entries.add(exportEntryDto);
        }

        entries.sort(Comparator.comparing(ExportEntryDto::getFinishTime));
        ExportWantedRacerDto exportWantedRacerDto = new ExportWantedRacerDto(racer.getName(), entries);
        ExportMostWanted exportMostWanted = new ExportMostWanted(exportWantedRacerDto);

        return exportMostWanted;
    }
}
