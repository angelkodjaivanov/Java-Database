package app.retake.controllers;

import app.retake.domain.dto.VetWrapperXMLImportDTO;
import app.retake.domain.dto.VetXMLImportDTO;
import app.retake.parser.JSONParser;
import app.retake.parser.ValidationUtil;
import app.retake.parser.XMLParser;
import app.retake.parser.interfaces.Parser;
import app.retake.services.api.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
public class VetController {

    private final VetService vetService;
    private final Parser parser;

    @Autowired
    public VetController(VetService vetService, @Qualifier("XMLParser") Parser parser) {
        this.vetService = vetService;
        this.parser = parser;
    }

    public String importDataFromXML(String xmlContent) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            VetWrapperXMLImportDTO vets = parser.read(VetWrapperXMLImportDTO.class, xmlContent);
            vets.getVets().forEach(a ->{
                if(ValidationUtil.isValid(a)){
                    this.vetService.create(a);
                    stringBuilder.append(String.format("Record %s is successfully imported", a.getName()))
                        .append(System.lineSeparator());
                }
                else{
                    stringBuilder.append("Error: Invalid data.").append(System.lineSeparator());
                }
            });
        }catch (IOException | JAXBException e){
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
