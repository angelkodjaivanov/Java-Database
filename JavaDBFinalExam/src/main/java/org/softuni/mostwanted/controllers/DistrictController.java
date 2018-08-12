package org.softuni.mostwanted.controllers;

import org.softuni.mostwanted.domain.dtos.ImportDistrictDto;
import org.softuni.mostwanted.domain.dtos.ImportTownDto;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.DistrictService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
public class DistrictController {

    private final DistrictService districtService;
    private final Parser parser;

    public DistrictController(DistrictService districtService, @Qualifier("JSONParser") Parser parser) {
        this.districtService = districtService;
        this.parser = parser;
    }


    public String importDistrictsFromJSON(String content){
        StringBuilder stringBuilder = new StringBuilder();

        try {
            ImportDistrictDto[] districts = parser.read(ImportDistrictDto[].class, content);

            for (ImportDistrictDto dto:districts) {
                if(dto.getName() != null && dto.getTownName() != null) {
                    if(this.districtService.findOneByName(dto.getName()) == null) {
                        this.districtService.create(dto);
                        stringBuilder.append(String.format("Successfully imported District - %s", dto.getName()))
                                .append(System.lineSeparator());
                    }
                    else{
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
}
