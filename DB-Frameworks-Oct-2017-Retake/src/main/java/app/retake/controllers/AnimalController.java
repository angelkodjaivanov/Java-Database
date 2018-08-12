package app.retake.controllers;

import app.retake.domain.dto.AnimalJSONImportDTO;
import app.retake.domain.models.Animal;
import app.retake.parser.JSONParser;
import app.retake.parser.ValidationUtil;
import app.retake.parser.interfaces.Parser;
import app.retake.services.api.AnimalService;
import javafx.scene.chart.ValueAxis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.text.ParseException;

@Controller
public class AnimalController {

    private final AnimalService animalService;
    private final Parser parser;

    public AnimalController(AnimalService animalService, @Qualifier("JSONParser") Parser parser) {
        this.animalService = animalService;
        this.parser = parser;
    }

    public String importDataFromJSON(String jsonContent) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            AnimalJSONImportDTO[] animalJSONImportDTOS = parser.read(AnimalJSONImportDTO[].class, jsonContent);
            for (AnimalJSONImportDTO animalJSONImportDTO : animalJSONImportDTOS) {
                if (ValidationUtil.isValid(animalJSONImportDTO)) {
                    boolean hasValidData = true;
                    try {
                        this.animalService.create(animalJSONImportDTO);
                    } catch (IllegalArgumentException e) {
                        hasValidData = false;
                    }
                    if (hasValidData) {
                        stringBuilder.append(String.format("Record %s Passport №: %s successfully imported.", animalJSONImportDTO.getName()
                                , animalJSONImportDTO.getPassport().getSerialNumber()))
                                .append(System.lineSeparator());
                    } else {
                        stringBuilder.append("Error: Invalid data.").append(System.lineSeparator());
                    }
                } else {
                    stringBuilder.append("Error: Invalid data.").append(System.lineSeparator());
                }
            }
        }catch (IOException | ParseException | JAXBException e){
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

    public String exportAnimalsByOwnerPhoneNumber(String phoneNumber) {
        return null;
    }
}
