package app.retake.services.impl;


import app.retake.domain.dto.AnimalAidJSONImportDTO;
import app.retake.domain.models.AnimalAid;
import app.retake.parser.interfaces.ModelParser;
import app.retake.repositories.AnimalAidRepository;
import app.retake.services.api.AnimalAidService;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AnimalAidServiceImpl implements AnimalAidService {


    private AnimalAidRepository animalAidRepository;

    private ModelParser modelParser;

    @Autowired
    public AnimalAidServiceImpl(AnimalAidRepository animalAidRepository, ModelParser modelParser) {
        this.animalAidRepository = animalAidRepository;
        this.modelParser = modelParser;
    }

    @Override
    public void create(AnimalAidJSONImportDTO dto) {
        AnimalAid animalAid = this.animalAidRepository.findByName(dto.getName());

        if(animalAid == null){
            this.animalAidRepository.saveAndFlush(this.modelParser.convert(dto, AnimalAid.class));
        }
        else{
            animalAid.setPrice(dto.getPrice());
            this.animalAidRepository.saveAndFlush(animalAid);
        }

    }
}
