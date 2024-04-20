package com.ftn.realestatemanagement.controller;


import com.ftn.realestatemanagement.dto.LocationDto;
import com.ftn.realestatemanagement.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/locations")
public class LocationController {

    private final LocationService locationService;


    @GetMapping("/view")
    public String index(Model model) {
        model.addAttribute("location" , locationService.getAllLocations());
        return "/locations";
    }


    @GetMapping("/add")
    public String showLocationForm(Model model){
        model.addAttribute("location", new LocationDto());
        return "fragments/AddLocation";
    }
    @PostMapping("/add")
    public String createLocation(LocationDto locationDto){

        locationService.createLocation(locationDto);

        return "redirect:/";
    }
    @GetMapping("delete/{id}")
    public String deleteLocation(@PathVariable Long id){
        locationService.deleteLocation(id);
        return "redirect:/locations/view";
    }


}
