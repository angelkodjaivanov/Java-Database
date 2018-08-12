package org.softuni.mostwanted.controllers;

import org.softuni.mostwanted.domain.dtos.ImportWrapperRaceEntries;
import org.softuni.mostwanted.domain.entities.RaceEntry;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.RaceEntryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
public class RaceEntryController {

    private final RaceEntryService raceEntryService;
    private final Parser parser;

    public RaceEntryController(RaceEntryService raceEntryService, @Qualifier("XMLParser") Parser parser) {
        this.raceEntryService = raceEntryService;
        this.parser = parser;
    }

    public String importRaceEntryFromXML(String content){
        StringBuilder stringBuilder = new StringBuilder();

        try {
            ImportWrapperRaceEntries cars = parser.read(ImportWrapperRaceEntries.class, content);
            cars.getEntries().forEach(dto ->{
                this.raceEntryService.save(dto);
                RaceEntry raceEntry = this.raceEntryService.findOneByRacerNameAndCarId(dto.getRacer(),
                        dto.getCarId());
                stringBuilder.append(String.format("Successfully imported RaceEntry - %d", raceEntry.getId()))
                .append(System.lineSeparator());

            });
        }
        catch (IOException | JAXBException e){
            e.printStackTrace();
        }


        return stringBuilder.toString();
    }
}
