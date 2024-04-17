package com.ftn.realestatemanagement.service;

import com.ftn.realestatemanagement.dto.AgencyDto;
import com.ftn.realestatemanagement.dto.EstateDto;
import com.ftn.realestatemanagement.model.Agency;

import java.util.List;

public interface AgencyService {


    Agency getById(Long id);

    List<AgencyDto> getAllAgencies();

    AgencyDto createAgency(AgencyDto agencyDto);

    AgencyDto getByIdDto(Long id);

    void deleteAgency(Long id);

    AgencyDto editAgency(AgencyDto agencyDto);
}
