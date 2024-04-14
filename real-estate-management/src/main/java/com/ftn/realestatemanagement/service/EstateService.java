package com.ftn.realestatemanagement.service;

import com.ftn.realestatemanagement.dto.EstateDto;
import com.ftn.realestatemanagement.model.Location;
import com.ftn.realestatemanagement.model.PropertyType;
import com.ftn.realestatemanagement.model.SaleStatus;
import com.ftn.realestatemanagement.dto.VisitRequestDto;
import com.ftn.realestatemanagement.model.Estate;

import java.util.List;

public interface EstateService {

    List<EstateDto> getAllActiveEstates();

    Estate getById(Long id);

    List<EstateDto> getAllEstates();


    EstateDto getByIdDto(Long id);

    EstateDto createEstate(EstateDto estateDto);

    EstateDto editEstate(EstateDto estateDto);

    void deleteEstate(Long id);

    List<EstateDto> searchEstates(String name,  String city, Integer fromArea, Integer toArea,
                                  Double fromPrice, Double toPrice, PropertyType propertyType,
                                  SaleStatus saleStatus, Long agencyId);
}
