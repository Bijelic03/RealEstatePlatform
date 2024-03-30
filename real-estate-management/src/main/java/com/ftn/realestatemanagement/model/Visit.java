package com.ftn.realestatemanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Visit {
    @Id
    private long id;
    private boolean estateReview;
    private boolean sold;
}
