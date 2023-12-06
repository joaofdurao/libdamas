package br.com.libdamas.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("student")
public class Student extends User{
    
    public Student() {
        // Default constructor
    }
    
    public Student(String name, String phoneNumber, String enrollment, String password) {
        super.setName(name);
        super.setPhoneNumber(phoneNumber);
        super.setEnrollment(enrollment);
        super.setPasssword(password);
    }

    @Override
    public String toString() {
        return "Student [name=" + super.getName() + ", phoneNumber=" + super.getPhoneNumber() + ", enrollment=" + super.getEnrollment() + "]";
    }
    
}
