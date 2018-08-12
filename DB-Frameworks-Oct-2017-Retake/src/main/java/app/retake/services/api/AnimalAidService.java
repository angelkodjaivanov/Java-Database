package app.retake.services.api;

import app.retake.domain.dto.AnimalAidJSONImportDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public interface AnimalAidService {
    void create(AnimalAidJSONImportDTO dto);
}
