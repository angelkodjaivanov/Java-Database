package db_advanced.spring_lab_01.model;

import com.mysql.jdbc.Blob;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 4, max = 30)
    private String name;

    @NotNull
    private String password;

    @NotNull
    private String email;

    @Column(name = "profile_picture")
    private Blob profilePicture;

    @Column(name = "registered_on")
    private Date registeredOn;

    @Column(name = "last_time_logged_on")
    private Date lastTimeLoggedOn;

    @Min(1)
    @Max(120)
    private Integer age;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @ManyToOne(optional = false)
    @JoinColumn(name = "born_town_id", referencedColumnName = "id")
    private Town bornTown;

    @ManyToOne(optional = false)
    @JoinColumn(name = "living_town_id", referencedColumnName = "id")
    private Town livingTown;

    public User() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Blob getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Blob profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Date getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(Date registeredOn) {
        this.registeredOn = registeredOn;
    }

    public Date getLastTimeLoggedOn() {
        return lastTimeLoggedOn;
    }

    public void setLastTimeLoggedOn(Date lastTimeLoggedOn) {
        this.lastTimeLoggedOn = lastTimeLoggedOn;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Town getBornTown() {
        return bornTown;
    }

    public void setBornTown(Town bornTown) {
        this.bornTown = bornTown;
    }

    public Town getLivingTown() {
        return livingTown;
    }

    public void setLivingTown(Town livingTown) {
        this.livingTown = livingTown;
    }
}
