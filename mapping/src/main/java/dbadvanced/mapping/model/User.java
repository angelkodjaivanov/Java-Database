package dbadvanced.mapping.model;

import dbadvanced.mapping.enums.Role;

import javax.lang.model.util.ElementScanner7;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Pattern(regexp = "^[a-zA-Z.]+@[a-zA-Z]+\\.[a-zA-Z]+$", message =
        "Incorrect email.")
    private String email;

    private String password;

    private String fullName;

    @OneToMany(mappedBy = "buyer", targetEntity = Game.class)
    private List<Game> games;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean loggedIn;

    public User() {
    }

    public User(String email,
                String password, String fullName, Role role) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.games = new ArrayList<>();
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
