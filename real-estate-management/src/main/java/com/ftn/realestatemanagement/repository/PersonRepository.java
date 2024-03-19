package com.ftn.realestatemanagement.repository;

import com.ftn.realestatemanagement.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("SELECT u FROM User u WHERE u.username = :username")
    public Person getUserByUsername(@Param("username") String username);
}
