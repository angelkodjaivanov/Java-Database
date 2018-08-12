package app.retake.services.api;

import app.retake.domain.dto.AnimalJSONImportDTO;
import app.retake.domain.dto.AnimalsJSONExportDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.util.List;

@Service
@Transactional
public interface AnimalService {
    void create(AnimalJSONImportDTO dto) throws ParseException;
    List<AnimalsJSONExportDTO> findByOwnerPhoneNumber(String phoneNumber);
}
