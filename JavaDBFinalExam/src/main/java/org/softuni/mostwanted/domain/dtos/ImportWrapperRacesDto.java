package org.softuni.mostwanted.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "races")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportWrapperRacesDto {

    @XmlElement(name = "race")
    private List<ImportRacesDto> races;

    public ImportWrapperRacesDto() {
    }

    public List<ImportRacesDto> getRaces() {
        return races;
    }

    public void setRaces(List<ImportRacesDto> races) {
        this.races = races;
    }
}
