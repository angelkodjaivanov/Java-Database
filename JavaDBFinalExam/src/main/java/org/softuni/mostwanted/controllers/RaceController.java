package org.softuni.mostwanted.controllers;

import org.softuni.mostwanted.domain.dtos.ImportWrapperRacesDto;
import org.softuni.mostwanted.domain.entities.Race;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.RaceService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
public class RaceController {

    private final RaceService raceService;
    private final Parser parser;

    public RaceController(RaceService raceService, @Qualifier("XMLParser") Parser parser) {
        this.raceService = raceService;
        this.parser = parser;
    }

    public String importRacesFromXML(String content){
        StringBuilder stringBuilder = new StringBuilder();

        try {
            ImportWrapperRacesDto races = parser.read(ImportWrapperRacesDto.class, content);
            races.getRaces().forEach(dto ->{
                    this.raceService.save(dto);
                    Race race = this.raceService.findOneByDistrictNameAndLaps(dto.getDistrictName(),
                            dto.getLaps());
                    stringBuilder.append(String.format("Successfully imported Race - %d",
                            race.getId()))
                            .append(System.lineSeparator());
            });
        }
        catch (IOException | JAXBException e){
            e.printStackTrace();
        }


        return stringBuilder.toString();
    }
}
