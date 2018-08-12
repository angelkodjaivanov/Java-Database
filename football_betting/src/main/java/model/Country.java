package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "country", targetEntity = Town.class,
        fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Town> towns;

    @ManyToMany
    @JoinTable(name = "countries_continents",
        joinColumns = @JoinColumn(name = "country_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "continent_id", referencedColumnName = "id"))
    private List<Continent> continents;

    public Country() {
    }

    public Country(String name) {
        this.name = name;
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

    public List<Town> getTowns() {
        return towns;
    }

    public void setTowns(List<Town> towns) {
        this.towns = towns;
    }

    public List<Continent> getContinents() {
        return continents;
    }

    public void setContinents(List<Continent> continents) {
        this.continents = continents;
    }
}
