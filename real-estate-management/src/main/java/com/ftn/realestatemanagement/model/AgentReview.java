package com.ftn.realestatemanagement.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "AgentReview")
@Data
@Builder
@AllArgsConstructor
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
