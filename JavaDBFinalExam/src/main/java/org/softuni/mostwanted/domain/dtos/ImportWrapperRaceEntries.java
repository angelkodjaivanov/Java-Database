package org.softuni.mostwanted.domain.dtos;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="race-entries")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportWrapperRaceEntries {

    @XmlElement(name = "race-entry")
    private List<ImportRaceEntries> entries;

    public ImportWrapperRaceEntries() {
    }

    public List<ImportRaceEntries> getEntries() {
        return entries;
    }

    public void setEntries(List<ImportRaceEntries> entries) {
        this.entries = entries;
    }
}
