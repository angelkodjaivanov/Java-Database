package org.softuni.mostwanted.domain.dtos;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "racer")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExportWantedRacerDto {

    @XmlAttribute
    private String name;

    @XmlElementWrapper(name = "entries")
    @XmlElement(name = "entry")
    private List<ExportEntryDto> entries;

    public ExportWantedRacerDto() {
    }

    public ExportWantedRacerDto(String name, List<ExportEntryDto> entries) {
        this.name = name;
        this.entries = entries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ExportEntryDto> getEntries() {
        return entries;
    }

    public void setEntries(List<ExportEntryDto> entries) {
        this.entries = entries;
    }
}
