package org.softuni.mostwanted.domain.dtos;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "race")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportRacesDto {

    @XmlElement
    private Integer laps;

    @XmlElement(name = "district-name")
    private String districtName;

    @XmlElementWrapper(name = "entries")
    @XmlElement(name = "entry")
    private List<ImportRaceEntryDto> entries;

    public ImportRacesDto() {
    }

    public Integer getLaps() {
        return laps;
    }

    public void setLaps(Integer laps) {
        this.laps = laps;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public List<ImportRaceEntryDto> getEntries() {
        return entries;
    }

    public void setEntries(List<ImportRaceEntryDto> entries) {
        this.entries = entries;
    }
}
