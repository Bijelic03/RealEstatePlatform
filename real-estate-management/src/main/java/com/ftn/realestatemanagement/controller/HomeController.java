package com.ftn.realestatemanagement.controller;

import com.ftn.realestatemanagement.service.EstateService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final EstateService estateService;

    @GetMapping
    public ModelAndView getHome() {
        return new ModelAndView("home").addObject("estates", estateService.getAllEstates());
    }
}
