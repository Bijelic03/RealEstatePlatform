package com.ftn.realestatemanagement.repository;

import com.ftn.realestatemanagement.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    @Query("SELECT l FROM Location l WHERE l.id NOT IN (SELECT e.location.id FROM Estate e)")
    List<Location> findUnusedLocations();
}
