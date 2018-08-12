package org.softuni.mostwanted.terminal;

import org.softuni.mostwanted.controllers.*;
import org.softuni.mostwanted.io.interfaces.ConsoleIO;
import org.softuni.mostwanted.io.interfaces.FileIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class Terminal implements CommandLineRunner {

    private final String JSON_TOWNS = "/files/json/input/towns.json";
    private final String JSON_DISTRICTS = "/files/json/input/districts.json";
    private final String JSON_RACERS = "/files/json/input/racers.json";
    private final String JSON_CARS = "/files/json/input/cars.json";
    private final String XML_RACE_ENTRIES = "/files/xml/input/race-entries.xml";
    private final String XML_RACES = "/files/xml/input/races.xml";

    private final TownController townController;
    private final DistrictController districtController;
    private final RacerController racerController;
    private final CarController carController;
    private final RaceEntryController raceEntryController;
    private final RaceController raceController;
    private final FileIO fileIO;
    private final ConsoleIO consoleIO;

    @Autowired
    public Terminal(TownController townController, DistrictController districtController, RacerController racerController, CarController carController, RaceEntryController raceEntryController, RaceController raceController, FileIO fileIO, ConsoleIO consoleIO) {
        this.townController = townController;
        this.districtController = districtController;
        this.racerController = racerController;
        this.carController = carController;
        this.raceEntryController = raceEntryController;
        this.raceController = raceController;
        this.fileIO = fileIO;
        this.consoleIO = consoleIO;
    }

    @Override
    public void run(String... args) throws Exception {
        consoleIO.write(this.townController.importTownsFromJSON(fileIO.read(JSON_TOWNS)));
        consoleIO.write(this.districtController.importDistrictsFromJSON(fileIO.read(JSON_DISTRICTS)));
        consoleIO.write(this.racerController.importRacerFromJSON(fileIO.read(JSON_RACERS)));
        consoleIO.write(this.carController.importCarsFromJSON(fileIO.read(JSON_CARS)));
        consoleIO.write(this.raceEntryController.importRaceEntryFromXML(fileIO.read(XML_RACE_ENTRIES)));
        consoleIO.write(this.raceController.importRacesFromXML(fileIO.read(XML_RACES)));

        fileIO.write(this.townController.exportRacingTownsToXML(), "/files/json/output/racing-towns.json");
        fileIO.write(this.racerController.exportRacersToXML(), "/files/json/output/racingCars.json");
        fileIO.write(this.racerController.exportMostWantedRacer(), "/files/xml/output/most-wanted.xml");
    }
}
