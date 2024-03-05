package com.ftn.realestatemanagement.model;

import jakarta.persistence.*;
import lombok.*;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitRequest {
    @Id
    private long id;
    private Date dateTime;
    private boolean accepted;
    @ManyToOne
    private User user;
    @OneToOne
    private Visit visit;
    @OneToMany(orphanRemoval = true)
    private Set<Estate> estates = new HashSet<>();
}
