package br.com.libdamas.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("professor")
public class Professor extends User{

    public Professor() {
    }

    public Professor(String name, String phoneNumber, String enrollment, String password) {
        super.setName(name);
        super.setPhoneNumber(phoneNumber);
        super.setEnrollment(enrollment);
        super.setPasssword(password);
    }

    @Override
    public String toString() {
        return "Professor [name=" + super.getName() + ", phoneNumber=" + super.getPhoneNumber() + ", enrollment=" + super.getEnrollment() + "]";
    }
    
}
