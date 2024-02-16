package com.ftn.realestatemanagement.service.impl;

import com.ftn.realestatemanagement.dto.EstateDto;
import com.ftn.realestatemanagement.dto.LocationDto;
import com.ftn.realestatemanagement.model.Location;
import com.ftn.realestatemanagement.repository.EstateRepository;
import com.ftn.realestatemanagement.repository.LocationRepository;
import com.ftn.realestatemanagement.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    @Override
    public Location getById(long id) {
        return locationRepository.getReferenceById(id);
    }

    @Override
    public List<LocationDto> getAllLocations() {
        return locationRepository.findAll().stream().map(LocationDto::convertToDto).toList();
    }

    @Override
    public LocationDto createLocation(LocationDto locationDto) {
        return LocationDto.convertToDto(locationRepository.save(locationDto.convertToModel()));
    }

    @Override
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
