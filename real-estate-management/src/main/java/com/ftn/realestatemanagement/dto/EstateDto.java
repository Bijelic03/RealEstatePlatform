package com.ftn.realestatemanagement.dto;

import com.ftn.realestatemanagement.model.Estate;
import com.ftn.realestatemanagement.model.Location;
import com.ftn.realestatemanagement.model.PropertyType;
import com.ftn.realestatemanagement.model.SaleStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class EstateDto {

    private long id;

    private long agencyId;

    private String name;

    private int area;

    private boolean active;

    private double price;

    private Location location;

    private PropertyType propertyType;

    private SaleStatus saleStatus;

    private String imagePath;

    public static EstateDto convertToDto(Estate estate) {
        return EstateDto.builder()
                .id(estate.getId())
                .agencyId(estate.getAgency().getId())
                .name(estate.getName())
                .area(estate.getArea())
                .active(estate.getActive())
                .price(estate.getPrice())
                .location(estate.getLocation())
                .propertyType(estate.getPropertyType())
                .saleStatus(estate.getSaleStatus())
                .imagePath(estate.getImages().get(0).getName())
                .build();
    }

    public Estate convertToModel() {
        return Estate.builder()
                .id(getId())
                .name(getName())
                .area(getArea())
                .active(isActive())
                .price(getPrice())
                .location(getLocation())
                .propertyType(getPropertyType())
                .saleStatus(getSaleStatus())
                .build();
    }
}
