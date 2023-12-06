package br.com.libdamas.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
public class Admin extends User{

    @Override
    public String toString() {
        return "Admin [name=" + super.getName() + ", phoneNumber=" + super.getPhoneNumber() + ", enrollment=" + super.getEnrollment() + "]";
    }
    
    
}
