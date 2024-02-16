package com.ftn.realestatemanagement.service;

import com.ftn.realestatemanagement.dto.EstateDto;
import com.ftn.realestatemanagement.dto.LocationDto;
import com.ftn.realestatemanagement.model.Location;

import java.util.List;

public interface LocationService {
    Location getById(long id);

    public List<LocationDto> getAllLocations();
    LocationDto createLocation(LocationDto locationDto);

    void deleteLocation(Long id);
}
