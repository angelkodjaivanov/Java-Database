package app.retake.services.impl;

import app.retake.domain.dto.VetXMLImportDTO;
import app.retake.domain.models.Vet;
import app.retake.parser.interfaces.ModelParser;
import app.retake.repositories.VetRepository;
import app.retake.services.api.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class VetServiceImpl implements VetService {

    private final VetRepository vetRepository;
    private final ModelParser mapper;

    @Autowired
    public VetServiceImpl(VetRepository vetRepository, ModelParser mapper) {
        this.vetRepository = vetRepository;
        this.mapper = mapper;
    }

    @Override
    public void create(VetXMLImportDTO dto) {
        this.vetRepository.saveAndFlush(this.mapper.convert(dto, Vet.class));
    }
}
