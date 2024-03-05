package com.ftn.realestatemanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Agent")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Agent extends Person {
    @OneToMany(orphanRemoval = true)
    private Set<AgentReview> reviews = new HashSet<>();
    @ManyToOne
    private Agency agency;
    @OneToMany(orphanRemoval = true)
    private Set<Estate> estates = new HashSet<>();
}
