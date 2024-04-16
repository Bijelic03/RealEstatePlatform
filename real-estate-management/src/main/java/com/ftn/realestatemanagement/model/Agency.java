package com.ftn.realestatemanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "Agency")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    @OneToOne
    private Person agencyOwner;
}
