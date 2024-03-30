package com.ftn.realestatemanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;


@Entity(name = "Agency")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agency {
    @Id
    private long id;
    private String name;
    private String address;
    @OneToOne
    private Person agencyOwner;
}
