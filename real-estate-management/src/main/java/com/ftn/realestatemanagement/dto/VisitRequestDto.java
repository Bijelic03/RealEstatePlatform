package com.ftn.realestatemanagement.dto;

import com.ftn.realestatemanagement.model.VisitRequest;
import lombok.*;


import java.util.Date;

@Data
@Builder
public class VisitRequestDto {

    private long id;

    private Date dateTime;

    private boolean accepted;

    private Long userId;

    private Long estateId;

    private VisitDto visit;

    public static VisitRequestDto convertToDto(VisitRequest visitRequest) {
        return VisitRequestDto.builder()
                .id(visitRequest.getId())
                .dateTime(visitRequest.getDateTime())
                .accepted(visitRequest.isAccepted())
                .userId(visitRequest.getUser().getId())
                .estateId(visitRequest.getEstate().getId())
                .visit(VisitDto.convertToDto(visitRequest.getVisit()))
                .build();
    }

    public VisitRequest convertToModel() {
        return VisitRequest.builder()
                .id(getId())
                .dateTime(getDateTime())
                .accepted(isAccepted())
                .build();
    }
}
