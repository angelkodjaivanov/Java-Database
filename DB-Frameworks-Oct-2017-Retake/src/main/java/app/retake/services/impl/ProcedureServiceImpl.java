package app.retake.services.impl;

import app.retake.domain.dto.ProcedureWrapperXMLExportDTO;
import app.retake.domain.dto.ProcedureXMLImportDTO;
import app.retake.domain.models.Animal;
import app.retake.domain.models.AnimalAid;
import app.retake.domain.models.Procedure;
import app.retake.domain.models.Vet;
import app.retake.parser.interfaces.ModelParser;
import app.retake.repositories.AnimalAidRepository;
import app.retake.repositories.AnimalRepository;
import app.retake.repositories.ProcedureRepository;
import app.retake.repositories.VetRepository;
import app.retake.services.api.ProcedureService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProcedureServiceImpl implements ProcedureService {

    private final ProcedureRepository procedureRepository;
    private final ModelParser modelParser;
    private final AnimalRepository animalRepository;
    private final VetRepository vetRepository;
    private final AnimalAidRepository animalAidRepository;

    public ProcedureServiceImpl(ProcedureRepository procedureRepository,
                                ModelParser modelParser,
                                AnimalRepository animalRepository,
                                VetRepository vetRepository, AnimalAidRepository animalAidRepository) {
        this.procedureRepository = procedureRepository;
        this.modelParser = modelParser;
        this.animalRepository = animalRepository;
        this.vetRepository = vetRepository;
        this.animalAidRepository = animalAidRepository;
    }

    @Override
    public void create(ProcedureXMLImportDTO dto) throws ParseException {
        Vet vet = this.vetRepository.findOneByName(dto.getVet());
        Animal animal = this.animalRepository.findOneByPassportSerialNumber(dto.getAnimal());

        if(vet == null || animal == null){
            throw new IllegalArgumentException();
        }
        else{
            Set<AnimalAid> animalAidSet = dto.getAnimalAids().stream().map(animalAidDto->{
                AnimalAid animalAid = this.animalAidRepository.findByName(animalAidDto.getName());
                if(animalAid == null) throw new IllegalArgumentException();
                return animalAid;
            }).collect(Collectors.toSet());
            Procedure procedure = new Procedure();
            procedure.setAnimal(animal);
            procedure.setVet(vet);
            procedure.setServices(animalAidSet);
            procedure.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(dto.getDate()));
            this.procedureRepository.saveAndFlush(procedure);
        }

    }

    @Override
    public ProcedureWrapperXMLExportDTO exportProcedures() {
        return null;
    }
}

