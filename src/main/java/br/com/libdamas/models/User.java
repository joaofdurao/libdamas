package br.com.libdamas.models;

import java.util.List;

public class User {
    private long id;
    private char name;
    private char phoneNumber;
    private char enrollment;
    private char type;
    private List<Book> userBooks;

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

}
