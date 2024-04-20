package com.ftn.realestatemanagement.controller;

import org.springframework.ui.Model;
import com.ftn.realestatemanagement.dto.PersonDto;
import com.ftn.realestatemanagement.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public ResponseEntity<List<PersonDto>> getAllUsers() {
        return ResponseEntity.ok(personService.getAllUsers());
    }

    @GetMapping("/view")
    public  String index(Model model) {

        model.addAttribute("person", personService.getAllUsers());
        return "persons";

    }

    @GetMapping("/addOwner")
    public String ShowOwnerCreatenForm(Model model){
        model.addAttribute("Korisnici", new PersonDto());

        return "fragments/addAgencyOwner";
    }

    @PostMapping("/addOwner")
    public String createOwner(@ModelAttribute  PersonDto personDto){
        personService.createOwner(personDto);
        return "redirect:/";
    }

    @GetMapping("/addAgent")
    public String ShowAgentCreationForm(Model model){
        model.addAttribute("Korisnici", new PersonDto());

        return "fragments/addAgent";
    }

    @PostMapping("/addAgent")
    public String createAgent(@ModelAttribute PersonDto personDto){
        personService.createAgent(personDto);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
        return "redirect:/users/view";
    }
}