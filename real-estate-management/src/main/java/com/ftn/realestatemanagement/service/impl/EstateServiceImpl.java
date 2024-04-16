package com.ftn.realestatemanagement.service.impl;

import com.ftn.realestatemanagement.dto.EstateDto;
import com.ftn.realestatemanagement.model.Location;
import com.ftn.realestatemanagement.model.PropertyType;
import com.ftn.realestatemanagement.model.SaleStatus;
import com.ftn.realestatemanagement.repository.EstateRepository;
import com.ftn.realestatemanagement.service.EstateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstateServiceImpl implements EstateService {

    private final EstateRepository estateRepository;

    @Override
    public List<EstateDto> getAllEstates() {
        return estateRepository.findAll().stream().map(EstateDto::convertToDto).toList();
    }

    @Override
    public List<EstateDto>searchEstates(String name, String city, Integer fromArea, Integer toArea,
                                         Double fromPrice, Double toPrice, PropertyType propertyType,
                                         SaleStatus saleStatus, Long agencyId) {

        System.out.println("Radim");

        return estateRepository.findByParams(name, fromArea, toArea, fromPrice, toPrice, propertyType,
                saleStatus, agencyId)
                .stream()
                .map(EstateDto::convertToDto)
                .toList();
    }

}