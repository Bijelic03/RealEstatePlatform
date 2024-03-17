package com.ftn.realestatemanagement.repository;

import com.ftn.realestatemanagement.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
