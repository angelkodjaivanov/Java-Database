package app.retake.controllers;

import app.retake.domain.dto.ProcedureWrapperXMLExportDTO;
import app.retake.domain.dto.ProcedureWrapperXMLImportDTO;
import app.retake.domain.dto.ProcedureXMLImportDTO;
import app.retake.services.api.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.text.ParseException;

import app.retake.parser.interfaces.Parser;

@Controller
public class ProcedureController {

    private final ProcedureService procedureService;
    private final Parser parser;

    public ProcedureController(ProcedureService procedureService, @Qualifier("XMLParser")Parser parser) {
        this.procedureService = procedureService;
        this.parser = parser;
    }


    public String importDataFromXML(String xmlContent){
        StringBuilder stringBuilder = new StringBuilder();

        try {
            ProcedureWrapperXMLImportDTO procedures = parser.read(ProcedureWrapperXMLImportDTO.class, xmlContent);

            procedures.getProcedures().forEach(procedure ->{
                try {
                    this.procedureService.create(procedure);
                    stringBuilder.append("Record successfully imported.").append(System.lineSeparator());
                }
                catch (IllegalArgumentException e){
                    stringBuilder.append("Error: Invalid data.").append(System.lineSeparator());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });

        }
        catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public String exportProcedures() throws IOException, JAXBException {
        return null;
    }
}
