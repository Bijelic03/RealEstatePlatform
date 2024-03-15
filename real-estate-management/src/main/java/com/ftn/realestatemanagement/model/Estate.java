package com.ftn.realestatemanagement.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Estate implements Serializable {
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
    @OneToMany
    private Set<Image> images = new HashSet<>();

    protected Estate(){

    }

    public Estate(long id, String name, int area, boolean active, double price, Location location, PropertyType propertyType, SaleStatus saleStatus, Set<Image> images) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.active = active;
        this.price = price;
        this.location = location;
        this.propertyType = propertyType;
        this.saleStatus = saleStatus;
        this.images = images;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public SaleStatus getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(SaleStatus saleStatus) {
        this.saleStatus = saleStatus;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }
}
