package com.ftn.realestatemanagement.service.impl;

import com.ftn.realestatemanagement.dto.AgencyDto;
import com.ftn.realestatemanagement.model.Agency;
import com.ftn.realestatemanagement.repository.AgencyRepository;
import com.ftn.realestatemanagement.service.AgencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgencyServiceImpl implements AgencyService {

    private final AgencyRepository agencyRepository;
    @Override
    public Agency getById(Long id) {
        return agencyRepository.getReferenceById(id);
    }

    @Override
    public List<AgencyDto> getAllAgencies() {
        return agencyRepository.findAll().stream().map(AgencyDto::convertToDto).toList();
    }

}
