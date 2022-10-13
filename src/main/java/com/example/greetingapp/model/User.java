package com.example.greetingapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String fistName;
    private String lastName;
    public User() {
    }
    public User(String fistName, String lastName) {
        this.fistName=fistName;
        this.lastName=lastName;
    }
    public String getFirstName() {
        return fistName;
    }
    public void setFirstName(String fistName) {
        this.fistName = fistName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}