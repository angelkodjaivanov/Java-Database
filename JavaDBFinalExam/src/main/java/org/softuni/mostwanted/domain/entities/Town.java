package org.softuni.mostwanted.domain.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "town", targetEntity = District.class)
    private Set<District> district;

    @OneToMany(mappedBy = "homeTown", targetEntity = Racer.class)
    private Set<Racer> racers;

    public Town() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<District> getDistrict() {
        return district;
    }

    public void setDistrict(Set<District> district) {
        this.district = district;
    }

    public Set<Racer> getRacers() {
        return racers;
    }

    public void setRacers(Set<Racer> racers) {
        this.racers = racers;
    }
}
