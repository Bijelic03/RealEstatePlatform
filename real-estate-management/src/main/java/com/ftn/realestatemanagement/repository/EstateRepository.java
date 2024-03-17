package com.ftn.realestatemanagement.repository;

import com.ftn.realestatemanagement.model.Estate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstateRepository extends JpaRepository<Estate, Long> {
}
