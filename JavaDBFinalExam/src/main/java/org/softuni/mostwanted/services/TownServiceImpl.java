package org.softuni.mostwanted.services;

import org.softuni.mostwanted.domain.dtos.ExportRacingTown;
import org.softuni.mostwanted.domain.dtos.ImportTownDto;
import org.softuni.mostwanted.domain.entities.Race;
import org.softuni.mostwanted.domain.entities.Racer;
import org.softuni.mostwanted.domain.entities.Town;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repositories.RacerRepository;
import org.softuni.mostwanted.repositories.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final RacerRepository racerRepository;
    private final ModelParser parser;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, RacerRepository racerRepository, ModelParser parser) {
        this.townRepository = townRepository;
        this.racerRepository = racerRepository;
        this.parser = parser;
    }

    @Override
    public void create(ImportTownDto dto) {
        Town town = this.townRepository.findOneByName(dto.getName());

        if(town == null){
            this.townRepository.saveAndFlush(this.parser.convert(dto, Town.class));
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Town findOneByName(String name) {
        Town town = this.townRepository.findOneByName(name);
        return town;
    }

    @Override
    public List<ExportRacingTown> exportsRacingTowns() {
        List<Town> towns = this.townRepository.findAll();
        List<ExportRacingTown> exportRacingTowns = new ArrayList<>();

        for (Town town:towns
             ) {
            List<Racer> racers = this.racerRepository.findByHomeTown(town);
            ExportRacingTown exportRacingTown = new ExportRacingTown(town.getName(), racers.size());
            if(racers.size() > 0) {
                exportRacingTowns.add(exportRacingTown);
            }
        }
        exportRacingTowns.sort(Comparator.comparing(ExportRacingTown::getRacers).reversed().
                thenComparing(Comparator.comparing(ExportRacingTown::getName)));

        return exportRacingTowns;
    }

}
