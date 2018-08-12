package org.softuni.mostwanted.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "most-wanted")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExportMostWanted {

    @XmlElement(name = "racer")
    private ExportWantedRacerDto racer;

    public ExportMostWanted() {
    }

    public ExportMostWanted(ExportWantedRacerDto racer) {
        this.racer = racer;
    }

    public ExportWantedRacerDto getRacer() {
        return racer;
    }

    public void setRacer(ExportWantedRacerDto racer) {
        this.racer = racer;
    }
}
