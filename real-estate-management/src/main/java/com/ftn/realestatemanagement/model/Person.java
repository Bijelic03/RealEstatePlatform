package com.ftn.realestatemanagement.model;




import jakarta.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    private PersonType role;

    private String username;

    private String password;

    private String name;

    private String surname;

    private String address;

    private String phone;

    private String email;

}
