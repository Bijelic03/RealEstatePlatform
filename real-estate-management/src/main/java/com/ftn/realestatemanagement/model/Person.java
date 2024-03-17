package com.ftn.realestatemanagement.model;




import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity(name = "Person")
public class Person implements Serializable {
    @Id
    private long id;

    private String username;

    private String password;

    private String name;

    private String surname;

    public Person() {
    }

    public Person(long id, String username, String password, String name, String surname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public Person(String username, String password, String name, String surname) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
