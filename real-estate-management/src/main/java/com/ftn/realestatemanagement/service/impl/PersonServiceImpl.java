package com.ftn.realestatemanagement.service.impl;

import com.ftn.realestatemanagement.dto.PersonDto;
import com.ftn.realestatemanagement.model.Person;
import com.ftn.realestatemanagement.model.PersonType;
import com.ftn.realestatemanagement.repository.PersonRepository;
import com.ftn.realestatemanagement.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.ftn.realestatemanagement.model.PersonType.USER;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public PersonDto login(PersonDto personDto) {
    return PersonDto.convertToDto(personRepository.getUserByUsernameAndPassword(personDto.getUsername(), personDto.getPassword()));
    }

    @Override
    public Optional<PersonDto> register(PersonDto personDto) {
        personDto.setRole(USER);
        return personRepository.getUserByUsername(personDto.getUsername())
                .map(user -> Optional.<PersonDto>empty())
                .orElseGet(() -> Optional.of(PersonDto.convertToDto(personRepository.save(personDto.convertToModel()))));
    }

    @Override
    public Person getById(Long id) {
        System.out.println("ID koji se prosleđuje metodi getById: " + id);
        return personRepository.getReferenceById(id);
    }

    @Override
    public List<PersonDto> getAllUsers() {
        return personRepository.findAll().stream()
                .map(PersonDto::convertToDto).toList();

    }

    @Override
    public PersonDto createOwner(PersonDto personDto) {
        Person person = personDto.convertToModel();
        person.setRole(PersonType.AGENCY_OWNER);
        return PersonDto.convertToDto(personRepository.save(person));
    }
    @Override
    public PersonDto createAgent(PersonDto personDto) {
        Person person = personDto.convertToModel();
        person.setRole(PersonType.AGENT);
        return PersonDto.convertToDto(personRepository.save(person));
    }
}