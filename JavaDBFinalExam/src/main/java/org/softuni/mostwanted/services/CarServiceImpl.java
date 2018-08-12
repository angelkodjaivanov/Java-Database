package org.softuni.mostwanted.services;


import org.softuni.mostwanted.domain.dtos.ImportCarDto;
import org.softuni.mostwanted.domain.entities.Car;
import org.softuni.mostwanted.domain.entities.Racer;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repositories.CarRepository;
import org.softuni.mostwanted.repositories.RacerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final ModelParser parser;
    private final RacerRepository racerRepository;
    private final RacerService racerService;

    public CarServiceImpl(CarRepository carRepository, ModelParser parser, RacerRepository racerRepository, RacerService racerService) {
        this.carRepository = carRepository;
        this.parser = parser;
        this.racerRepository = racerRepository;
        this.racerService = racerService;
    }

    @Override
    public void save(ImportCarDto dto) {
        Car car = new Car();
        Racer racer = this.racerRepository.findOneByName(dto.getRacerName());
        car.setBrand(dto.getBrand());
        car.setModel(dto.getModel());
        car.setPrice(dto.getPrice());
        car.setMaxSpeed(dto.getMaxSpeed());
        car.setRacer(racer);
        car.setZeroToSixty(dto.getZeroToSixty());
        car.setYearOfProduction(dto.getYearOfProduction());
        this.carRepository.saveAndFlush(car);
    }

    @Override
    public Car findCar(String brand, String model, Integer yearOfProduction, Integer racerId) {
        Racer racer = this.racerService.findOneById(racerId);
        Car car = this.carRepository.findOneByBrandAndModelAndYearOfProductionAndRacer(
                brand, model, yearOfProduction, racer
        );
        return car;
    }
}
