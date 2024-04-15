package com.ftn.realestatemanagement.dto;

import com.ftn.realestatemanagement.model.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationDto {

    private long id;

    private long postalCode;

    private String county;

    private String city;

    private String district;

    private String street;

    private String streetNumber;


    public static LocationDto convertToDto(Location location){
        return LocationDto.builder()
                .id(location.getId())
                .postalCode(location.getPostalCode())
                .county(location.getCountry())
                .city(location.getCity())
                .district(location.getDistrict())
                .street(location.getStreet())
                .streetNumber(location.getStreetNumber())
                .build();
    }


    public Location convertToModel(){
        return Location.builder()
                .id(getId())
                .postalCode(getPostalCode())
                .country(getCounty())
                .city(getCity())
                .district(getDistrict())
                .street(getStreet())
                .streetNumber(getStreetNumber())
                .build();
    }
}
