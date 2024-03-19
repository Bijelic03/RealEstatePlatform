package com.ftn.realestatemanagement.repository;

import com.ftn.realestatemanagement.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
