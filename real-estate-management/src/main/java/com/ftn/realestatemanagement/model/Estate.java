package com.ftn.realestatemanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estate {
    @Id
    private long id;
    private String name;
    private int area;
    private boolean active = true;
    private double price;
    @ManyToOne
    private Location location;
    private PropertyType propertyType;
    private SaleStatus saleStatus;

}