package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(optional = false)
    @JoinColumn(name = "home_team", referencedColumnName = "id")
    private Team homeTeam;

    @OneToOne(optional = false)
    @JoinColumn(name = "away_team", referencedColumnName = "id")
    private Team awayTeam;

    @Column(name = "home_team_goals")
    private Integer homeTeamGoals;

    @Column(name = "away_team_goals")
    private Integer awayTeamGoals;

    @Column(name = "date_time")
    private String dateTime;

    @Column(name = "home_team_win_bet_rate")
    private Double homeTeamWinBetRate;

    @Column(name = "away_team_win_bet_rate")
    private Double awayTeamWinBetRate;

    @Column(name = "draw_game_bet_rate")
    private Double drawGameBetRate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "round_id", referencedColumnName = "id")
    private Round round;

    @ManyToOne(optional = false)
    @JoinColumn(name = "competition_id", referencedColumnName = "id")
    private Competition competition;

    @ManyToMany(mappedBy = "games", targetEntity = Player.class)
    private List<Player> players;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "bet_id", referencedColumnName = "id")
    )
    private List<Bet> bets;

    public Game() {
    }

    public Game(Integer homeTeamGoals, Integer awayTeamGoals, String dateTime, Double homeTeamWinBetRate,
                Double awayTeamWinBetRate, Double drawGameBetRate) {
        this.homeTeamGoals = homeTeamGoals;
        this.awayTeamGoals = awayTeamGoals;
        this.dateTime = dateTime;
        this.homeTeamWinBetRate = homeTeamWinBetRate;
        this.awayTeamWinBetRate = awayTeamWinBetRate;
        this.drawGameBetRate = drawGameBetRate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Integer getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(Integer homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    public Integer getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public void setAwayTeamGoals(Integer awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Double getHomeTeamWinBetRate() {
        return homeTeamWinBetRate;
    }

    public void setHomeTeamWinBetRate(Double homeTeamWinBetRate) {
        this.homeTeamWinBetRate = homeTeamWinBetRate;
    }

    public Double getAwayTeamWinBetRate() {
        return awayTeamWinBetRate;
    }

    public void setAwayTeamWinBetRate(Double awayTeamWinBetRate) {
        this.awayTeamWinBetRate = awayTeamWinBetRate;
    }

    public Double getDrawGameBetRate() {
        return drawGameBetRate;
    }

    public void setDrawGameBetRate(Double drawGameBetRate) {
        this.drawGameBetRate = drawGameBetRate;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }
}
