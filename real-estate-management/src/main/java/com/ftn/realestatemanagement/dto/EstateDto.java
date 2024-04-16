package com.ftn.realestatemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import com.ftn.realestatemanagement.model.Estate;
import com.ftn.realestatemanagement.model.Location;
import com.ftn.realestatemanagement.model.PropertyType;
import com.ftn.realestatemanagement.model.SaleStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstateDto {

    private Long id;

    private Long agencyId;

    private String name;

    private int area;

    private boolean active;

    private double price;

    private Location location;

    private PropertyType propertyType;

    private SaleStatus saleStatus;

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
                .build();
    }

    public Estate convertToModel() {
        return Estate.builder()
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
