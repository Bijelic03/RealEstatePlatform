package com.ftn.realestatemanagement.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity(name = "agency")
public class Agency implements Serializable {
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    private long id;
    private String name;
    private String address;
    @OneToMany(orphanRemoval = true)
    private List<Agent> agents;
    @OneToOne
    private AgencyOwner agencyOwner;


    protected Agency(){

    }

    public Agency(long id, String name, String address, List<Agent> agents, AgencyOwner agencyOwner) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.agents = agents;
        this.agencyOwner = agencyOwner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

    public AgencyOwner getAgencyOwner() {
        return agencyOwner;
    }

    public void setAgencyOwner(AgencyOwner agencyOwner) {
        this.agencyOwner = agencyOwner;
    }
}
