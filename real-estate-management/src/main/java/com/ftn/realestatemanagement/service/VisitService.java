package com.ftn.realestatemanagement.service;

import com.ftn.realestatemanagement.dto.AgentReviewDto;
import com.ftn.realestatemanagement.dto.VisitRequestDto;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface VisitService {

    VisitRequestDto findVisitRequestById(Long id);

    VisitRequestDto bookVisit(VisitRequestDto visitRequestDto);

    List<VisitRequestDto> getAllVisitRequestsByAgentId(Long id);

    void acceptVisit(Long visitRequestId);

    void rejectVisit(Long visitRequestId);

    void leaveEstateReview(Long visitId, boolean review);

    void leaveAgentReview(AgentReviewDto agentReviewDto) throws BadRequestException;
}
