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
import org.springframework.web.bind.annotation.*;
import com.ftn.realestatemanagement.model.PropertyType;
import com.ftn.realestatemanagement.model.SaleStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

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

        System.out.println("Received attributes:");
        System.out.println("Name: " + name);
        System.out.println("City: " + city);
        System.out.println("From Area: " + fromArea);
        System.out.println("To Area: " + toArea);
        System.out.println("From Price: " + fromPrice);
        System.out.println("To Price: " + toPrice);
        System.out.println("Property Type: " + propertyType);
        System.out.println("Sale Status: " + saleStatus);
        System.out.println("Agency ID: " + agencyId);

        return ResponseEntity.ok(estateService.searchEstates(name, city, fromArea, toArea,
                fromPrice, toPrice, propertyType, saleStatus, agencyId));
    }


    @GetMapping("/add")
    public String showEstateCreationForm(Model model){
        model.addAttribute("estate", new EstateDto());

        List<LocationDto> locationList = locationService.getAllUnusedLocations();
        model.addAttribute("locations", locationList);

        List<AgencyDto> agencyList = agencyService.getAllAgencies();
        model.addAttribute("agencies", agencyList);
        return "fragments/addEstate";
    }

    @PostMapping("/add")
    public String createEstate(@ModelAttribute EstateDto estateDto, @RequestParam("images") List<MultipartFile> images) {
        estateService.createEstate(estateDto, images);
        return "redirect:/";
    }


    @GetMapping("/edit/{id}")
    public String showEstateEditForm(Model model, @PathVariable Long id) {


        model.addAttribute("estate", estateService.getByIdDto(id));

        List<LocationDto> locationList = locationService.getAllLocations();
        model.addAttribute("locations", locationList);

        List<AgencyDto> agencyList = agencyService.getAllAgencies();
        model.addAttribute("agencies", agencyList);
        return "fragments/editEstate";
    }
    @PostMapping("/edit")
    public String editEstate(@RequestBody EstateDto estateDto){
        estateService.editEstate(estateDto);

        return "redirect:/";
    }


    @DeleteMapping("/delete/{id}")
    public String deleteEstate(@PathVariable Long id){
        estateService.deleteEstate(id);
        return "redirect:/";
    }



    }
