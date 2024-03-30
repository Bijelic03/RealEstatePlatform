package com.ftn.realestatemanagement.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "AgentReview")
@Data
@NoArgsConstructor
public class AgentReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int rating;
    private String description;
    @ManyToOne
    private Person agent;
    @OneToOne
    private Visit visit;
}
