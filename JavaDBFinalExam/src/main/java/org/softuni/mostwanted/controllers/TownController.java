package org.softuni.mostwanted.controllers;

import org.softuni.mostwanted.domain.dtos.ExportRacingTown;
import org.softuni.mostwanted.domain.dtos.ImportTownDto;
import org.softuni.mostwanted.domain.entities.Town;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.TownService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TownController {

    private final TownService townService;
    private final Parser parser;

    public TownController(TownService townService, @Qualifier("JSONParser") Parser parser) {
        this.townService = townService;
        this.parser = parser;
    }


    public String importTownsFromJSON(String content){
        StringBuilder stringBuilder = new StringBuilder();

        try {
            ImportTownDto[] towns = parser.read(ImportTownDto[].class, content);

            for (ImportTownDto dto:towns) {
                if(dto.getName() != null) {
                    try {
                        this.townService.create(dto);
                        stringBuilder.append(String.format("Successfully imported Town - %s", dto.getName()))
                                .append(System.lineSeparator());
                    } catch (IllegalArgumentException e) {
                        stringBuilder.append("Error: Duplicate Data!").append(System.lineSeparator());
                    }
                }
                else{
                    stringBuilder.append("Error: Incorrect Data!").append(System.lineSeparator());
                }
            }
        }catch (IOException | JAXBException e){
            stringBuilder.append("Error: Incorrect Data!").append(System.lineSeparator());
        }


        return stringBuilder.toString();
    }

    public String exportRacingTownsToXML() {
        try {
            return parser.write(this.townService.exportsRacingTowns());
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
