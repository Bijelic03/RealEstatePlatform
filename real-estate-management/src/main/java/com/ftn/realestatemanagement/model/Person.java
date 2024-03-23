package com.ftn.realestatemanagement.model;




import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "Person")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    private long id;

    private String username;

    private String password;

    private String name;

    private String surname;
}
