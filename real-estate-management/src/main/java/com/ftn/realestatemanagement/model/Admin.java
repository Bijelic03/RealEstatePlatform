package com.ftn.realestatemanagement.model;

import jakarta.persistence.Entity;

import java.io.Serializable;


@Entity(name = "Admin")
public class Admin extends Person  implements Serializable {

    protected Admin(){

    }

    public Admin(long id, String username, String password, String name, String surname) {
        super(id, username, password, name, surname);
    }


}
