package com.ftn.realestatemanagement.repository;

import com.ftn.realestatemanagement.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
