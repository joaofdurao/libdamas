package br.com.libdamas.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("student")
public class Student extends User{

    @Override
    public String toString() {
        return "Student [name=" + super.getName() + ", phoneNumber=" + super.getPhoneNumber() + ", enrollment=" + super.getEnrollment() + "]";
    }
    
}
