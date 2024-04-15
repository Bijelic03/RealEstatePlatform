package com.ftn.realestatemanagement.repository;

import com.ftn.realestatemanagement.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EstateRepository extends JpaRepository<Estate, Long> {

    @Query("SELECT e FROM Estate e WHERE " +
            "(e.active = true)" +
            "AND (:name IS NULL OR e.name LIKE %:name%) " +
            "AND (:city IS NULL OR e.location.city = :city) " +
            "AND (:fromArea IS NULL OR e.area >= :fromArea) " +
            "AND (:toArea IS NULL OR e.area <= :toArea) " +
            "AND (:fromPrice IS NULL OR e.price >= :fromPrice) " +
            "AND (:toPrice IS NULL OR e.price <= :toPrice) " +
            "AND (:propertyType IS NULL OR e.propertyType = :propertyType) " +
            "AND (:saleStatus IS NULL OR e.saleStatus = :saleStatus)" +
            "AND (:agencyId IS NULL OR e.agency.id = :agencyId)")
    List<Estate> findByParams(String name,
                              String city,
                              Integer fromArea,
                              Integer toArea,
                              Double fromPrice,
                              Double toPrice,
                              PropertyType propertyType,
                              SaleStatus saleStatus,
                              Long agencyId);


    List<Estate> findAllByActive(boolean active);



}
