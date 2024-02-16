package com.ftn.realestatemanagement.service.impl;

import com.ftn.realestatemanagement.dto.EstateDto;
import com.ftn.realestatemanagement.model.Location;
import com.ftn.realestatemanagement.model.PropertyType;
import com.ftn.realestatemanagement.model.SaleStatus;
import com.ftn.realestatemanagement.repository.EstateRepository;
import com.ftn.realestatemanagement.dto.VisitRequestDto;
import com.ftn.realestatemanagement.model.Estate;
import com.ftn.realestatemanagement.repository.EstateRepository;
import com.ftn.realestatemanagement.service.AgencyService;
import com.ftn.realestatemanagement.service.EstateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstateServiceImpl implements EstateService {

    private final EstateRepository estateRepository;
    private final AgencyService agencyService;

    @Override
    public List<EstateDto> getAllEstates() {
        return estateRepository.findAll().stream().map(EstateDto::convertToDto).toList();
    }

    @Override
    public Estate getById(Long id) {
        return estateRepository.getReferenceById(id);
    }

    @Override
    public EstateDto createEstate(EstateDto estateDto) {
        Estate estate = estateDto.convertToModel();
        estate.setAgency(agencyService.getById(estateDto.getAgencyId()));
        estate.setActive(true);
        return EstateDto.convertToDto(estateRepository.save(estate));
    }

    @Override
    public EstateDto editEstate(EstateDto estateDto) {
        Estate estate = getById(estateDto.getId());
        estate.setArea( estateDto.getArea());
        estate.setActive(estateDto.isActive());
        estate.setName(estateDto.getName());
        estate.setPrice(estateDto.getPrice());
        estate.setPropertyType(estateDto.getPropertyType());
        estate.setSaleStatus(estateDto.getSaleStatus());
        estate.setLocation(estateDto.getLocation());

        return EstateDto.convertToDto(estateRepository.save(estate));
    }

    @Override
    public void deleteEstate(Long id) {
        estateRepository.deleteById(id);
    }
    public List<EstateDto> searchEstates(String name, String city, Integer fromArea, Integer toArea,
                                         Double fromPrice, Double toPrice, PropertyType propertyType,
                                         SaleStatus saleStatus, Long agencyId) {

        return estateRepository.findByParams(name, city, fromArea, toArea, fromPrice, toPrice, propertyType,
                saleStatus, agencyId)
                .stream()
                .map(EstateDto::convertToDto)
                .toList();
    }

}