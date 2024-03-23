package com.ftn.realestatemanagement.repository;

import com.ftn.realestatemanagement.model.AgencyOwner;
import com.ftn.realestatemanagement.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {
}
