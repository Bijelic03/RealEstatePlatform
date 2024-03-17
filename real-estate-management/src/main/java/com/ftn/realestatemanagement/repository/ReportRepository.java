package com.ftn.realestatemanagement.repository;

import com.ftn.realestatemanagement.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
