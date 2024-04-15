package com.ftn.realestatemanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Estate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Agency agency;

    private String name;

    private int area;

    @Builder.Default
    private Boolean active = true;

    private double price;

    @ManyToOne
    private Location location;

    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;

    @Enumerated(EnumType.STRING)
    private SaleStatus saleStatus;

    @OneToMany(mappedBy = "estate", cascade = CascadeType.ALL) // OneToMany relationship
    private List<Image> images;
}