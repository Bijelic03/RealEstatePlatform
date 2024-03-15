package com.ftn.realestatemanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Location implements Serializable {
    @Id
    private long id;
    private long postalCode;
    private String country;
    private String city;
    private String district;
    private String street;
    private String streetNumber;

    protected Location(){

    }

    public Location(long id, long postalCode, String country, String city, String district, String street, String streetNumber) {
        this.id = id;
        this.postalCode = postalCode;
        this.country = country;
        this.city = city;
        this.district = district;
        this.street = street;
        this.streetNumber = streetNumber;
    }

    public Location(long id, long postalCode, String country, String city, String district) {
        this.id = id;
        this.postalCode = postalCode;
        this.country = country;
        this.city = city;
        this.district = district;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(long postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
}
