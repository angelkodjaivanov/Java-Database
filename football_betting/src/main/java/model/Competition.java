package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "competitions")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private String name;

    @OneToMany(mappedBy = "competition", targetEntity = Game.class)
    private List<Game> games;

    @OneToOne(optional = false)
    @JoinColumn(name = "competition_type", referencedColumnName = "id")
    private CompetitionType competitionType;

    public Competition() {
    }

    public Competition(String name) {
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

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public CompetitionType getCompetitionType() {
        return competitionType;
    }

    public void setCompetitionType(CompetitionType competitionType) {
        this.competitionType = competitionType;
    }
}
