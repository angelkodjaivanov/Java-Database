package model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private String username;

    @Basic
    private String password;

    @Basic
    private String email;

    @Column(name = "full_name")
    private String fullName;

    @Basic
    private BigDecimal balance;

    @OneToMany(mappedBy = "user", targetEntity = Bet.class)
    private List<Bet> bets;
}
