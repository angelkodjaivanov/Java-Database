package org.softuni.mostwanted.controllers;

import org.softuni.mostwanted.domain.dtos.RacerImportDto;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.RacerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
public class RacerController {

    private final RacerService racerService;
    private final Parser parser;
    private final Parser xmlParser;

    public RacerController(RacerService racerService, @Qualifier("JSONParser") Parser parser,
                           @Qualifier("XMLParser") Parser xmlParser) {
        this.racerService = racerService;
        this.parser = parser;
        this.xmlParser = xmlParser;
    }

    public String importRacerFromJSON(String content){
        StringBuilder stringBuilder = new StringBuilder();

        try {
            RacerImportDto[] racers = parser.read(RacerImportDto[].class,content );
            for (RacerImportDto dto:racers) {
                try {
                    this.racerService.save(dto);
                    stringBuilder.append(String.format("Successfully imported Racer - %s", dto.getName()))
                            .append(System.lineSeparator());
                }catch (IllegalArgumentException e){
                    stringBuilder.append("Error: Duplicate Data!").append(System.lineSeparator());
                }
            }
        }
        catch (IOException | JAXBException e){
            e.printStackTrace();
        }


        return stringBuilder.toString();
    }
    public String exportRacersToXML() {
        try {
            return parser.write(this.racerService.exportRacers());
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String exportMostWantedRacer() {
        try {
            return xmlParser.write(this.racerService.ExportMostWanted());
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}


