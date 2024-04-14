package com.ftn.realestatemanagement.controller;

import com.ftn.realestatemanagement.dto.EstateDto;
import com.ftn.realestatemanagement.model.Location;
import com.ftn.realestatemanagement.model.PropertyType;
import com.ftn.realestatemanagement.model.SaleStatus;
import com.ftn.realestatemanagement.service.EstateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/estates")
public class EstateController {

    private final EstateService estateService;

    @GetMapping("/search")
    public ResponseEntity<List<EstateDto>> searchEstates(@RequestParam(required = false) String name,
                                                        @RequestParam(required = false) String city,
                                                        @RequestParam(required = false) Integer fromArea,
                                                        @RequestParam(required = false) Integer toArea,
                                                        @RequestParam(required = false) Double fromPrice,
                                                        @RequestParam(required = false) Double toPrice,
                                                        @RequestParam(required = false) PropertyType propertyType,
                                                        @RequestParam(required = false) SaleStatus saleStatus,
                                                        @RequestParam(required = false) Long agencyId) {
        return ResponseEntity.ok(estateService.searchEstates(name, city, fromArea, toArea,
                fromPrice, toPrice, propertyType, saleStatus, agencyId));
    }
}
