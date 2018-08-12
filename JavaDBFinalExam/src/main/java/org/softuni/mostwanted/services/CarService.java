package org.softuni.mostwanted.services;

import org.softuni.mostwanted.domain.dtos.ImportCarDto;
import org.softuni.mostwanted.domain.entities.Car;

public interface CarService {
    void save(ImportCarDto dto);

    Car findCar(String brand, String model, Integer yearOfProduction, Integer racerId);
}
