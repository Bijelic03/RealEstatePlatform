package com.ftn.realestatemanagement.dto;

import com.ftn.realestatemanagement.model.Visit;
import com.ftn.realestatemanagement.model.VisitRequest;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VisitDto {

    private long id;

    private boolean estateReview;

    private boolean sold;

    public static VisitDto convertToDto(Visit visit) {
        return VisitDto.builder()
                .id(visit.getId())
                .estateReview(visit.isEstateReview())
                .sold(visit.isSold())
                .build();
    }

    public Visit convertToModel() {
        return Visit.builder()
                .id(getId())
                .estateReview(isEstateReview())
                .sold(isEstateReview())
                .build();
    }

}