package com.ftn.realestatemanagement.repository;

import com.ftn.realestatemanagement.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person getUserByUsernameAndPassword(String username, String password);

    Optional<Person> getUserByUsername(String username);
}