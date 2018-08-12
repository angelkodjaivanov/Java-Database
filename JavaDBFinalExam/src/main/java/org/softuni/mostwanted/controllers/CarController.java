package org.softuni.mostwanted.controllers;

import org.softuni.mostwanted.domain.dtos.ImportCarDto;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.CarService;
import org.softuni.mostwanted.services.RacerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
public class CarController {

    private final CarService carService;
    private final Parser parser;
    private final RacerService racerService;

    public CarController(CarService carService, @Qualifier("JSONParser") Parser parser, RacerService racerService) {
        this.carService = carService;
        this.parser = parser;
        this.racerService = racerService;
    }

    public String importCarsFromJSON(String content){
        StringBuilder stringBuilder = new StringBuilder();

        try {
            ImportCarDto[] cars = parser.read(ImportCarDto[].class,content );
            for (ImportCarDto dto:cars) {
                if(this.carService.findCar(dto.getBrand(), dto.getModel(), dto.getYearOfProduction()
                    , this.racerService.findOneByName(dto.getRacerName()).getId()) == null) {
                    try {
                        this.carService.save(dto);
                        stringBuilder.append(String.format("Successfully imported Car - %s %s @ %d",
                                dto.getBrand(), dto.getModel(), dto.getYearOfProduction()))
                                .append(System.lineSeparator());
                    } catch (IllegalArgumentException e) {
                        stringBuilder.append("Error: Duplicate Data!").append(System.lineSeparator());
                    }
                }
            }
        }
        catch (IOException | JAXBException e){
            e.printStackTrace();
        }


        return stringBuilder.toString();
    }
}
