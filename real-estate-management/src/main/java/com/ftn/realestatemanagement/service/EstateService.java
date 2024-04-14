package com.ftn.realestatemanagement.service;

import com.ftn.realestatemanagement.dto.EstateDto;
import com.ftn.realestatemanagement.model.Location;
import com.ftn.realestatemanagement.model.PropertyType;
import com.ftn.realestatemanagement.model.SaleStatus;

import java.util.List;

public interface EstateService {

    public List<EstateDto> getAllEstates();

    List<EstateDto> searchEstates(String name,  String city, Integer fromArea, Integer toArea,
                                  Double fromPrice, Double toPrice, PropertyType propertyType,
                                  SaleStatus saleStatus, Long agencyId);
}
