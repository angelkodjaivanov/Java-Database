package model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.xml.soap.Text;
import java.util.Date;

@Entity
@Table(name = "wizard_deposits")
public class WizardDeposits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50)
    private String first_name;

    @NotNull
    @Column(length = 60)
    private String last_name;

    @Column(length = 1000)
    private String notes;

    @Min(value = 0)
    @NotNull
    private int age;

    @Column(length = 100)
    private String magic_wand_creator;

    @Size(min = 1, max = 2^15 - 1)
    private int magic_wand_size;

    @Column(length = 20)
    private String deposit_group;

    @Basic
    private Date deposit_start_date;

    @Basic
    private double deposit_amount;

    @Basic
    private double deposit_interests;

    @Basic
    private double deposit_charge;

    @Basic
    private Date deposit_expiration_time;

    @Basic
    private boolean is_deposit_expired;
}

