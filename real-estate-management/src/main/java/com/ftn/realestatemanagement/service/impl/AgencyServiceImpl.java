
package com.ftn.realestatemanagement.service.impl;

import com.ftn.realestatemanagement.dto.AgencyDto;
import com.ftn.realestatemanagement.model.Agency;
import com.ftn.realestatemanagement.repository.AgencyRepository;
import com.ftn.realestatemanagement.service.AgencyService;
import com.ftn.realestatemanagement.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgencyServiceImpl implements AgencyService {

    private final AgencyRepository agencyRepository;

    private final PersonService personService;
    @Override
    public Agency getById(Long id) {
        return agencyRepository.getReferenceById(id);
    }

    @Override
    public List<AgencyDto> getAllAgencies() {
        return agencyRepository.findAll().stream().map(AgencyDto::convertToDto).toList();
    }

    @Override
    public AgencyDto createAgency(AgencyDto agencyDto) {

        Agency agency = agencyDto.convertToModel();
        agency.setAgencyOwner(personService.getById(agencyDto.getAgencyOwnerId()));


        return AgencyDto.convertToDto(agencyRepository.save(agency));
    }

    @Override
    public AgencyDto getByIdDto(Long id){
        return  AgencyDto.convertToDto(agencyRepository.getReferenceById(id));
    }

    public void deleteAgency(Long id) {
        agencyRepository.deleteById(id);
    }

    @Override
    public  AgencyDto editAgency(AgencyDto agencyDto){
        Agency agency = getById(agencyDto.getId());
        agency.setName(agencyDto.getName());
        agency.setAddress(agencyDto.getAddress());
        agency.setAgencyOwner(personService.getById(agencyDto.getAgencyOwnerId()));

        return AgencyDto.convertToDto(agencyRepository.save(agency));
    }





}


