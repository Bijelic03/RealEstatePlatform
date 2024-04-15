package com.ftn.realestatemanagement.dto;

import com.ftn.realestatemanagement.model.VisitRequest;
import com.ftn.realestatemanagement.service.EstateService;
import com.ftn.realestatemanagement.service.PersonService;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class VisitRequestDto {

    private final PersonService personService;

    private final EstateService estateService;

    private Long userId;

    private Long estateId;

    private Date date;

    private boolean accepted;

    public static VisitRequestDto convertToDto(VisitRequest visitRequest) {
        return VisitRequestDto.builder()
                .userId(visitRequest.getUser().getId())
                .estateId(visitRequest.getEstate().getId())
                .date(visitRequest.getDateTime())
                .accepted(visitRequest.isAccepted())
                .build();
    }

    public VisitRequest convertToModel(VisitRequestDto visitRequestDto) {
        return VisitRequest.builder()
                .user(personService.getById(getUserId()))
                .estate(estateService.getById(getEstateId()))
                .dateTime(getDate())
                .accepted(isAccepted())
                .build();
    }

}
