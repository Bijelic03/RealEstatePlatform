package com.ftn.realestatemanagement.dto;

import com.ftn.realestatemanagement.model.Agency;
import com.ftn.realestatemanagement.model.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AgencyDto {

    private Long id;

    private String name;

    private String address;

    private Long agencyOwnerId;

    public static AgencyDto convertToDto(Agency agency){
        return AgencyDto.builder()
                .id(agency.getId())
                .name(agency.getName())
                .address(agency.getAddress())
                .agencyOwnerId(agency.getAgencyOwner().getId())
                .build();
    }
    public Agency convertToModel(){
        return Agency.builder()
                .id(getId())
                .name(getName())
                .address(getAddress())
                .build();
    }
}
