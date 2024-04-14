package com.ftn.realestatemanagement.controller;

import com.ftn.realestatemanagement.dto.AgencyDto;
import com.ftn.realestatemanagement.dto.EstateDto;
import com.ftn.realestatemanagement.dto.LocationDto;
import com.ftn.realestatemanagement.service.AgencyService;
import com.ftn.realestatemanagement.service.EstateService;
import com.ftn.realestatemanagement.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ftn.realestatemanagement.model.PropertyType;
import com.ftn.realestatemanagement.model.SaleStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/estates")
public class EstateController {

    private final LocationService locationService;

    private final AgencyService agencyService;

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


    @GetMapping("/add")
    public String showEstateForm(Model model){
        model.addAttribute("estate", new EstateDto());

        List<LocationDto> locationList = locationService.getAllLocations();
        model.addAttribute("locations", locationList);

        List<AgencyDto> agencyList = agencyService.getAllAgencies();
        model.addAttribute("agencies", agencyList);
        return "fragments/addEstate";
    }

    @PostMapping("/add")
    public String createEstate(EstateDto estateDto){

        estateService.createEstate(estateDto);
        return "redirect:/";
    }

    }
