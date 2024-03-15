package com.ftn.realestatemanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "agent")
public class Agent extends Person  implements Serializable {
    @OneToMany(orphanRemoval = true)
    private Set<AgentReview> reviews;
    private Agency agency;

    protected Agent(){

    }

    public Agent(long id, String username, String password, String name, String surname, Agency agency) {
        super(id, username, password, name, surname);
        this.agency = agency;

    }

    public Agent(long id, String username, String password, String name, String surname, Agency agency, Set<AgentReview> reviews) {
        super(id, username, password, name, surname);
        this.agency = agency;
        this.reviews = reviews;

    }

    public Set<AgentReview> getReviews() {
        return reviews;
    }

    public void setReviews(Set<AgentReview> reviews) {
        this.reviews = reviews;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }
}
