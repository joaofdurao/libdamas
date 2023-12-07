package br.com.libdamas.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
public class Admin extends User{

    public Admin() {
    }

    public Admin(String name, String phoneNumber, String enrollment, String password) {
        super.setName(name);
        super.setPhoneNumber(phoneNumber);
        super.setEnrollment(enrollment);
        super.setPasssword(password);
    }

    @Override
    public String toString() {
        return "Admin [name=" + super.getName() + ", phoneNumber=" + super.getPhoneNumber() + ", enrollment=" + super.getEnrollment() + "]";
    }
    
    
}
