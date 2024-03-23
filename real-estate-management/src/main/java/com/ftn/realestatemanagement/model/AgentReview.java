package com.ftn.realestatemanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "AgentReview")
@Data
@NoArgsConstructor
public class AgentReview {
    @Id
    private long id;
    private int rating;
    private String description;
    @ManyToOne
    private Agent agent;
    @OneToOne
    private Visit visit;
}
