package com.ftn.realestatemanagement.dto;

import com.ftn.realestatemanagement.model.AgentReview;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AgentReviewDto {

    private Long id;

    private int rating;

    private String description;

    private String agentId;

    private Long visitId;

    public static AgentReviewDto convertToDto(AgentReview agentReview) {
        return AgentReviewDto.builder()
                .id(agentReview.getId())
                .rating(agentReview.getRating())
                .description(agentReview.getDescription())
                .visitId(agentReview.getVisit().getId())
                .build();
    }

    public AgentReview convertToModel() {
        return AgentReview.builder()
                .id(getId())
                .rating(getRating())
                .description(getDescription())
                .build();
    }
}
