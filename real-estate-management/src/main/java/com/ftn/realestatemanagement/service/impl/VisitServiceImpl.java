package com.ftn.realestatemanagement.service.impl;

import com.ftn.realestatemanagement.dto.AgentReviewDto;
import com.ftn.realestatemanagement.dto.VisitRequestDto;
import com.ftn.realestatemanagement.model.AgentReview;
import com.ftn.realestatemanagement.model.Visit;
import com.ftn.realestatemanagement.model.VisitRequest;
import com.ftn.realestatemanagement.repository.AgentReviewRepository;
import com.ftn.realestatemanagement.repository.PersonRepository;
import com.ftn.realestatemanagement.repository.VisitRepository;
import com.ftn.realestatemanagement.repository.VisitRequestRepository;
import com.ftn.realestatemanagement.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitServiceImpl implements VisitService {

    private final VisitRequestRepository visitRequestRepository;

    private final AgentReviewRepository agentReviewRepository;

    private final PersonRepository personRepository;

    private final VisitRepository visitRepository;

    @Override
    public VisitRequestDto findVisitRequestById(Long id) {
        return visitRequestRepository.findVisitRequestById(id);
    }

    @Override
    public VisitRequestDto bookVisit(VisitRequestDto visitRequestDto) {
        return visitRequestDto.convertToDto(visitRequestRepository.save(visitRequestDto.convertToModel()));
    }

    @Override
    public List<VisitRequestDto> getAllVisitRequestsByAgentId(Long id) {
        return visitRequestRepository.findVisitRequestByAgentId(id);
    }

    @Override
    public void acceptVisit(Long visitRequestId) {
        VisitRequest visitRequest = findVisitRequestById(visitRequestId).convertToModel();
        visitRequest.setAccepted(true);
        visitRequestRepository.save(visitRequest);
    }

    @Override
    public void rejectVisit(Long visitRequestId) {
        VisitRequest visitRequest = findVisitRequestById(visitRequestId).convertToModel();
        visitRequest.setAccepted(false);
        visitRequestRepository.save(visitRequest);
    }

    @Override
    public void leaveEstateReview(Long visitId, boolean review) {
        Visit visit = visitRepository.getReferenceById(visitId);
        visit.setEstateReview(review);
        visitRepository.save(visit);
    }

    @Override
    public void leaveAgentReview(AgentReviewDto agentReviewDto) throws BadRequestException {
        AgentReview agentReview = agentReviewDto.convertToModel();
        agentReview.setVisit(visitRepository.getReferenceById(agentReviewDto.getVisitId()));
        agentReview.setAgent(personRepository.findById(agentReviewDto.getId()).orElseThrow(() ->new BadRequestException()));
        agentReviewRepository.save(agentReview);
    }
}
