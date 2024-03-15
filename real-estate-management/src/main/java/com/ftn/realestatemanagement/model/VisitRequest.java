package com.ftn.realestatemanagement.model;

import jakarta.persistence.*;


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class VisitRequest implements Serializable {
    @Id
    private long id;
    private Date dateTime;
    private boolean accepted;
    @ManyToOne
    private User user;
    @OneToOne(optional = true)
    private Visit visit;
    @ManyToOne
    private Estate estate;

    protected VisitRequest(){

    }

    public VisitRequest(long id, Date dateTime, boolean accepted, User user, Visit visit, Estate estate) {
        this.id = id;
        this.dateTime = dateTime;
        this.accepted = accepted;
        this.user = user;
        this.visit = visit;
        this.estate = estate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    public Estate getEstate() {
        return estate;
    }

    public void setEstate(Estate estate) {
        this.estate = estate;
    }
}
