package com.ftn.realestatemanagement.service.impl;

import com.ftn.realestatemanagement.dto.AgentReviewDto;
import com.ftn.realestatemanagement.dto.VisitRequestDto;
import com.ftn.realestatemanagement.service.VisitService;

public class VisitServiceImpl implements VisitService {
    @Override
    public VisitRequestDto bookVisit(VisitRequestDto visitRequestDto) {
        return;
    }

    @Override
    public void acceptVisit(Long visitRequestId) {

    }

    @Override
    public void rejectVisit(Long visitRequestId) {

    }

    @Override
    public void leaveEstateReview(Long visitId, boolean review) {

    }

    @Override
    public void leaveAgentReview(AgentReviewDto agentReviewDto) {

    }
}
