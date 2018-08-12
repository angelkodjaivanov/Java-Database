package app.retake.domain.models;

import com.sun.javafx.geom.transform.Identity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "procedures")
public class Procedure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    @JoinTable(name = "animal_aids_procedures", joinColumns = @JoinColumn(name = "procedure_id" , referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "animal_aid_id", referencedColumnName = "id"))
    private Set<AnimalAid> services;

    @ManyToOne
    @JoinColumn(name = "animal_id", referencedColumnName = "id")
    private Animal animal;

    @Transient
    @Column(precision = 12, scale = 2)
    private BigDecimal cost;

    @ManyToOne
    @JoinColumn(name = "vet_id", referencedColumnName = "id")
    private Vet vet;

    private Date date;

    public Procedure() {
        this.services = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public BigDecimal getCost() {
        this.cost = BigDecimal.valueOf(0);

        for (AnimalAid service:this.services) {
            cost.add(BigDecimal.valueOf(service.getPrice()));
        }
        return cost;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<AnimalAid> getServices() {
        return services;
    }

    public void setServices(Set<AnimalAid> services) {
        this.services = services;
    }
}
