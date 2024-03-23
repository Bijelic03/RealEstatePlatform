package com.ftn.realestatemanagement.service;

import com.ftn.realestatemanagement.model.Person;
import com.ftn.realestatemanagement.repository.AdminRepository;
import com.ftn.realestatemanagement.repository.AgencyOwnerRepository;
import com.ftn.realestatemanagement.repository.AgentRepository;
import com.ftn.realestatemanagement.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private PersonRepository personRepository;

    @Autowired
    public AuthenticationService(PersonRepository personRepository){

    }

    public Person login(String username, String password){
        Person person = personRepository.getUserByUsername(username);
        return person != null ? person : null;
    }
}
