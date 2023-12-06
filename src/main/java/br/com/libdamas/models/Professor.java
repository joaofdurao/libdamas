package br.com.libdamas.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("professor")
public class Professor extends User{

    @Override
    public String toString() {
        return "Professor [name=" + super.getName() + ", phoneNumber=" + super.getPhoneNumber() + ", enrollment=" + super.getEnrollment() + "]";
    }
    
}
