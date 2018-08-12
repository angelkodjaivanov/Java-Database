package app.retake.controllers;

import app.retake.domain.dto.AnimalAidJSONImportDTO;
import app.retake.domain.models.AnimalAid;
import app.retake.parser.JSONParser;
import app.retake.parser.ModelParserImpl;
import app.retake.parser.ValidationUtil;
import app.retake.parser.interfaces.ModelParser;
import app.retake.parser.interfaces.Parser;
import app.retake.services.api.AnimalAidService;
import com.sun.javafx.binding.StringFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@Controller
public class AnimalAidController {

    private final AnimalAidService animalAidService;
    private final Parser parser;

    public AnimalAidController(AnimalAidService animalAidService, @Qualifier("JSONParser") Parser parser){
        this.animalAidService = animalAidService;
        this.parser = parser;
    }

    public String importDataFromJSON(String jsonContent){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            AnimalAidJSONImportDTO[] animalAidJSONImportDTOS = parser.read(AnimalAidJSONImportDTO[].class, jsonContent);
            for (AnimalAidJSONImportDTO animalAidJSONImportDTO : animalAidJSONImportDTOS) {
                if (ValidationUtil.isValid(animalAidJSONImportDTO)) {
                    this.animalAidService.create(animalAidJSONImportDTO);
                    stringBuilder.append(String.format("Record %s is successfully imported.", animalAidJSONImportDTO.getName()))
                            .append(System.lineSeparator());
                } else {
                    stringBuilder.append("Error: Invalid data.").append(System.lineSeparator());
                }
            }
        }
        catch (IOException | JAXBException e){
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
}
