package com.ftn.realestatemanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.io.Serializable;
import java.util.Date;

@Entity

public class Visit implements Serializable {
    @Id
    private long id;
    private boolean estateReview;
    private boolean sold;
    @OneToOne
    private VisitRequest visitRequest;
    @OneToOne(optional = true)
    private AgentReview agentReview;
    private Date date;

    protected Visit(){

    }
    public Visit(long id, boolean estateReview, boolean sold, VisitRequest visitRequest, AgentReview agentReview, Date date) {
        this.id = id;
        this.estateReview = estateReview;
        this.sold = sold;
        this.visitRequest = visitRequest;
        this.agentReview = agentReview;
        this.date = date;
    }

    public Visit(long id, boolean estateReview, boolean sold, AgentReview agentReview, Date date) {
        this.id = id;
        this.estateReview = estateReview;
        this.sold = sold;
        this.agentReview = agentReview;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isEstateReview() {
        return estateReview;
    }

    public void setEstateReview(boolean estateReview) {
        this.estateReview = estateReview;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public VisitRequest getVisitRequest() {
        return visitRequest;
    }

    public void setVisitRequest(VisitRequest visitRequest) {
        this.visitRequest = visitRequest;
    }

    public AgentReview getAgentReview() {
        return agentReview;
    }

    public void setAgentReview(AgentReview agentReview) {
        this.agentReview = agentReview;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
