package com.ftn.realestatemanagement.repository;

import com.ftn.realestatemanagement.dto.VisitRequestDto;
import com.ftn.realestatemanagement.model.VisitRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VisitRequestRepository extends JpaRepository<VisitRequest, Long> {

    VisitRequestDto findVisitRequestById(Long Id);

    @Query("SELECT v FROM VisitRequest v WHERE v.agent.id = :id")
    List<VisitRequestDto> findVisitRequestByAgentId(Long id);

}
