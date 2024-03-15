package com.ftn.realestatemanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

import java.io.Serializable;

@Entity(name = "AgencyOwner")

public class AgencyOwner extends Person  implements Serializable {
    @OneToOne
    private Agency agency;

    protected AgencyOwner(){

    }

    public AgencyOwner(long id, String username, String password, String name, String surname) {
        super(id, username, password, name, surname);
    }
    public AgencyOwner(long id, String username, String password, String name, String surname, Agency agency) {
        super(id, username, password, name, surname);
        this.agency = agency;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }
}
