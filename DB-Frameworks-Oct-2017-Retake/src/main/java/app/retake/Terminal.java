package app.retake;

import app.retake.controllers.AnimalAidController;
import app.retake.controllers.AnimalController;
import app.retake.controllers.ProcedureController;
import app.retake.controllers.VetController;
import app.retake.io.api.ConsoleIO;
import app.retake.io.api.FileIO;
import app.retake.services.api.AnimalAidService;
import app.retake.services.api.AnimalService;
import app.retake.services.api.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
@Component
public class Terminal implements CommandLineRunner {

    private FileIO fileIO;
    private ConsoleIO consoleIO;
    private AnimalAidController animalAidController;
    private AnimalController animalController;
    private VetController vetController;
    private ProcedureController procedureController;

    @Autowired
    public Terminal(FileIO fileIO, ConsoleIO consoleIO,
                    AnimalAidController animalAidController, AnimalController animalController,
                    VetController vetController, ProcedureController procedureController) {
        this.fileIO = fileIO;
        this.consoleIO = consoleIO;
        this.animalAidController = animalAidController;
        this.animalController = animalController;
        this.vetController = vetController;
        this.procedureController = procedureController;
    }

    @Override
    public void run(String... strings) throws Exception {
        consoleIO.write(this.animalAidController.importDataFromJSON(this.fileIO.read(Config.ANIMAL_AIDS_IMPORT_JSON)));
        consoleIO.write(this.animalController.importDataFromJSON(this.fileIO.read(Config.ANIMALS_IMPORT_JSON)));
        consoleIO.write(this.vetController.importDataFromXML(this.fileIO.read(Config.VETS_IMPORT_XML)));
        consoleIO.write(this.procedureController.importDataFromXML(this.fileIO.read(Config.PROCEDURES_IMPORT_XML)));
    }

}
