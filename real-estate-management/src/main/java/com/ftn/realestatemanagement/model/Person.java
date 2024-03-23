package com.ftn.realestatemanagement.model;




import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.*;

@Entity(name = "Person")
@Data
@NoArgsConstructor
@AllArgsConstructor

import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;

@MappedSuperclass
public class Person implements Serializable {

    @Id
    private long id;

    private String username;

    private String password;

    private String name;

    private String surname;



}
