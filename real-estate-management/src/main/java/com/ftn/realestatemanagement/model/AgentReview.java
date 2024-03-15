package com.ftn.realestatemanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.io.Serializable;

@Entity(name = "AgentReview")
public class AgentReview implements Serializable {
    @Id
    private long id;
    private int rating;
    private String description;
    private Agent agent;
    @OneToOne
    private Visit visit;

    protected AgentReview(){

    }

    public AgentReview(long id, int rating, String description, Agent agent, Visit visit) {
        this.id = id;
        this.rating = rating;
        this.description = description;
        this.agent = agent;
        this.visit = visit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }
}
