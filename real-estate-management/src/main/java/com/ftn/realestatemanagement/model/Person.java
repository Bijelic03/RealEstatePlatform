package com.ftn.realestatemanagement.model;




import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Entity(name = "Person")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    @Id
    private long id;

    private PersonType role;

    private String username;

    private String password;

    private String name;

    private String surname;

    private Location address;

    private String phone;

    private String email;

}
