package org.softuni.mostwanted.services;

import org.softuni.mostwanted.domain.dtos.ImportDistrictDto;
import org.softuni.mostwanted.domain.entities.District;
import org.softuni.mostwanted.domain.entities.Town;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repositories.DistrictRepository;
import org.softuni.mostwanted.repositories.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DistrictServiceImpl implements DistrictService {

    private final DistrictRepository districtRepository;
    private final TownRepository townRepository;
    private final ModelParser parser;

    @Autowired
    public DistrictServiceImpl(DistrictRepository districtRepository,
                               TownRepository townRepository,
                               ModelParser parser) {
        this.districtRepository = districtRepository;
        this.townRepository = townRepository;
        this.parser = parser;
    }

    @Override
    public void create(ImportDistrictDto dto) {
        District district = new District();
        Town town = this.townRepository.findOneByName(dto.getTownName());
        district.setName(dto.getName());
        district.setTown(town);
        this.districtRepository.saveAndFlush(district);
    }


    @Override
    public District findOneByName(String name) {
        District district = this.districtRepository.findOneByName(name);
        return district;
    }
}
