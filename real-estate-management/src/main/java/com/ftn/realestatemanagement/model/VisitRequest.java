package com.ftn.realestatemanagement.model;

import jakarta.persistence.*;
import lombok.*;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VisitRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date dateTime;
    private boolean accepted;
    @ManyToOne
    private Person user;
    @OneToOne
    private Visit visit;
    @ManyToOne
    private Estate estate;
    @ManyToOne
    private Person agent;
}
