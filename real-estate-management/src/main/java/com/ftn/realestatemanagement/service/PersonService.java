package com.ftn.realestatemanagement.service;

import com.ftn.realestatemanagement.dto.PersonDto;
import com.ftn.realestatemanagement.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    PersonDto login(PersonDto personDto);

    Optional<PersonDto> register(PersonDto personDto);

    List<PersonDto> getAllUsers();

}
