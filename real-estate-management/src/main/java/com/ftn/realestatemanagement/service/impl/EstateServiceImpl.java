package com.ftn.realestatemanagement.service.impl;

import com.ftn.realestatemanagement.dto.EstateDto;
import com.ftn.realestatemanagement.model.Estate;
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

}