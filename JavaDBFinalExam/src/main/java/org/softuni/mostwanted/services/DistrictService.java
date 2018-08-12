package org.softuni.mostwanted.services;

import org.softuni.mostwanted.domain.dtos.ImportDistrictDto;
import org.softuni.mostwanted.domain.entities.District;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface DistrictService {
    void create(ImportDistrictDto dto);

    District findOneByName(String name);
}
