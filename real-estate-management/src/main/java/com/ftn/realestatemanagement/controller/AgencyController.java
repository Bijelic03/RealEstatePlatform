package com.ftn.realestatemanagement.controller;

import com.ftn.realestatemanagement.dto.AgencyDto;
import com.ftn.realestatemanagement.dto.PersonDto;
import com.ftn.realestatemanagement.dto.LocationDto;
import com.ftn.realestatemanagement.service.AgencyService;
import com.ftn.realestatemanagement.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/agencies")
public class AgencyController {

    private final AgencyService agencyService;


    private  final PersonService personService;
    @GetMapping("/add")
    public String showAgencyCreationForm(Model model){
        model.addAttribute("agency", new AgencyDto());
        List<PersonDto> personList = personService.getAllUsers();
        model.addAttribute("person", personList);

        return "fragments/addAgency";
    }

    @PostMapping("/add")
    public String createEstate(@ModelAttribute AgencyDto agencyDto) {
        agencyService.createAgency(agencyDto);
        return "redirect:/";
    }


}
