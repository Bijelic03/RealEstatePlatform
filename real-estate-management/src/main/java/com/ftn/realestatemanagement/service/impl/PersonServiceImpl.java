package com.ftn.realestatemanagement.service.impl;

import com.ftn.realestatemanagement.dto.PersonDto;
import com.ftn.realestatemanagement.model.Person;
import com.ftn.realestatemanagement.repository.PersonRepository;
import com.ftn.realestatemanagement.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public PersonDto login(PersonDto personDto) {
    return PersonDto.convertToDto(personRepository.getUserByUsernameAndPassword(personDto.getUsername(), personDto.getPassword()));
    }

    @Override
    public List<PersonDto> getAllUsers() {
        return personRepository.findAll().stream()
                .map(PersonDto::convertToDto).toList();
    }
}