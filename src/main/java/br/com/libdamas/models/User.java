package br.com.libdamas.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "USERS_TB")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 5, max = 250)
    @Column(length = 250, nullable = false)
    private String name;

    @Pattern(regexp = "^\\(?[1-9]{2}\\)? ?(?:[2-8]|9[0-9])[0-9]{3}\\-?[0-9]{4}$")
    @Column(length = 10)
    private String phoneNumber;

    @NotNull
    @Size(max = 12)
    @Column(length = 12, nullable = false)
    private String enrollment;

    @NotNull
    @Size(min = 6)
    @Column(nullable = false)
    private String passsword;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Loan> loans;

    // O Hibernate deve ser capaz de criar uma coluna com o nome "type" como
    // descrito no "@DiscriminatorColumn"
    // @Column(length = 50)
    // private String type;

    public User() {
    }

    public User(String name, String phoneNumber, String enrollment, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.enrollment = enrollment;
        this.passsword = password;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    // O uso de Strings e getters and setters neste caso é proposital para facilitar o uso.
    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", phoneNumber=" + phoneNumber + ", enrollment=" + enrollment + "]";
    }

}
