package com.ftn.realestatemanagement.controller;

import com.ftn.realestatemanagement.dto.AgencyDto;
import com.ftn.realestatemanagement.dto.EstateDto;
import com.ftn.realestatemanagement.dto.LocationDto;
import com.ftn.realestatemanagement.service.AgencyService;
import com.ftn.realestatemanagement.service.EstateService;
import com.ftn.realestatemanagement.service.LocationService;
import jakarta.servlet.http.HttpSession;
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
    public String searchEstates(@RequestParam(required = false) String name,
                                                        @RequestParam(required = false) String city,
                                                        @RequestParam(required = false) Integer fromArea,
                                                        @RequestParam(required = false) Integer toArea,
                                                        @RequestParam(required = false) Double fromPrice,
                                                        @RequestParam(required = false) Double toPrice,
                                                        @RequestParam(required = false) PropertyType propertyType,
                                                        @RequestParam(required = false) SaleStatus saleStatus,
                                                        @RequestParam(required = false) Long agencyId,
                                Model model, HttpSession session) {

        model.addAttribute("estates", estateService.searchEstates(name, city, fromArea, toArea,
                fromPrice, toPrice, propertyType, saleStatus, agencyId));


        return "fragments/estates :: estateList";
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

    @GetMapping("/show/{id}")
    public String showEstate(Model model, @PathVariable Long id){


        model.addAttribute("estate", estateService.getByIdDto(id));

        List<LocationDto> locationList = locationService.getAllLocations();
        model.addAttribute("locations", locationList);

        List<AgencyDto> agencyList = agencyService.getAllAgencies();
        model.addAttribute("agencies", agencyList);
        return "fragments/Estate";
    }

    }
