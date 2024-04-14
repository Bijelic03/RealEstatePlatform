package com.ftn.realestatemanagement.service;

import com.ftn.realestatemanagement.dto.AgentReviewDto;
import com.ftn.realestatemanagement.dto.VisitRequestDto;

public interface VisitService {

    VisitRequestDto bookVisit(VisitRequestDto visitRequestDto);

    void acceptVisit(Long visitRequestId);

    void rejectVisit(Long visitRequestId);

    void leaveEstateReview(Long visitId, boolean review);

    void leaveAgentReview(AgentReviewDto agentReviewDto);
}
