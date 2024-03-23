package com.ftn.realestatemanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "User")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends Person {
    private String phone;
    private String email;
    @OneToMany(orphanRemoval = true)
    private Set<VisitRequest> visitRequests = new HashSet<>();
    @ManyToOne
    private Location address;
}
