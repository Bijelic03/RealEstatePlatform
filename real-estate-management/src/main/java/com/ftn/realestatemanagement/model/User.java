package com.ftn.realestatemanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "User")
public class User extends Person implements Serializable {
    private String phone;
    private String email;
    @OneToMany(orphanRemoval = true)
    private Set<VisitRequest> visitRequests = new HashSet<>();
    @ManyToOne
    private Location address;

    protected User(){

    }

    public User(long id, String username, String password, String name, String surname) {
        super(id, username, password, name, surname);
    }

    public User(long id, String username, String password, String name, String surname, String phone, String email, Set<VisitRequest> visitRequests, Location address) {
        super(id, username, password, name, surname);
        this.phone = phone;
        this.email = email;
        this.visitRequests = visitRequests;
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<VisitRequest> getVisitRequests() {
        return visitRequests;
    }

    public void setVisitRequests(Set<VisitRequest> visitRequests) {
        this.visitRequests = visitRequests;
    }

    public Location getAddress() {
        return address;
    }

    public void setAddress(Location address) {
        this.address = address;
    }
}
