package br.com.libdamas.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private char name;
    @Column
    private char phoneNumber;
    @Column
    private char enrollment;
    @Column
    private char type;
    @Column
    private List<Book> userBooks;

    public User() {
    }

    public User(long id, char name, char phoneNumber, char enrollment, char type, List<Book> userBooks) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.enrollment = enrollment;
        this.type = type;
        this.userBooks = userBooks;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public char getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(char phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public char getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(char enrollment) {
        this.enrollment = enrollment;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public List<Book> getUserBooks() {
        return userBooks;
    }

    public void setUserBooks(List<Book> userBooks) {
        this.userBooks = userBooks;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", enrollment=" + enrollment
                + ", type=" + type + ", userBooks=" + userBooks + "]";
    }

}
