package app.retake.services.impl;

import app.retake.domain.dto.AnimalJSONImportDTO;
import app.retake.domain.dto.AnimalsJSONExportDTO;
import app.retake.domain.models.Animal;
import app.retake.domain.models.Passport;
import app.retake.parser.interfaces.ModelParser;
import app.retake.repositories.AnimalRepository;
import app.retake.repositories.PassportRepository;
import app.retake.services.api.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.List;

@Service
@Transactional
public class AnimalServiceImpl implements AnimalService {

    private AnimalRepository animalRepository;
    private ModelParser modelParser;
    private PassportRepository passportRepository;

    @Autowired
    public AnimalServiceImpl(AnimalRepository animalRepository, ModelParser modelParser, PassportRepository passportRepository) {
        this.animalRepository = animalRepository;
        this.modelParser = modelParser;
        this.passportRepository = passportRepository;
    }

    @Override
    public void create(AnimalJSONImportDTO dto) throws ParseException {
        Animal animal = this.modelParser.convert(dto, Animal.class);
        if(this.passportRepository.findOne(animal.getPassport().getSerialNumber()) == null){
            this.animalRepository.saveAndFlush(animal);
        }
        else{
            throw new IllegalArgumentException();
        }

    }

    @Override
    public List<AnimalsJSONExportDTO> findByOwnerPhoneNumber(String phoneNumber) {
       return this.findByOwnerPhoneNumber(phoneNumber);
    }
}
