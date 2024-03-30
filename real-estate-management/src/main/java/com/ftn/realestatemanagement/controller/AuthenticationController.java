package com.ftn.realestatemanagement.controller;

import com.ftn.realestatemanagement.dto.PersonDto;
import com.ftn.realestatemanagement.model.Person;
import com.ftn.realestatemanagement.service.PersonService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;


@Controller
@RequiredArgsConstructor
public class AuthenticationController {

    public static final String LOGED_IN_USER = "loged_in_user";

    private final PersonService personService;

    private final ServletContext servletContext;

    @GetMapping("/login")
    public String showLoginForm(HttpSession session) {
        return "login";
    }

    @PostMapping("/login")
    public String login(PersonDto personDto, HttpSession session, HttpServletRequest request, Model model) {
        session.removeAttribute(LOGED_IN_USER);
        session = request.getSession(true);

        PersonDto logedInUser = personService.login(personDto);

        if (logedInUser != null) {
            session.setAttribute(LOGED_IN_USER, logedInUser);
            return "redirect:/";
        } else {
            model.addAttribute("loginError", "Korisnik ne postoji ili su uneti pogrešni podaci.");
            return "login";
        }
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute(LOGED_IN_USER);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("korisnik", new PersonDto());
        model.addAttribute("userAlreadyExists", false);
        model.addAttribute("showModal", false);
        return "register";
    }

    @PostMapping("/register")
    public String register(PersonDto personDto, Model model, HttpSession session,
                           HttpServletRequest request) {

        if (personService.register(personDto).isPresent()) {

            session = request.getSession(true);

            session.setAttribute(LOGED_IN_USER, personDto);

            return "redirect:/";
        } else {

            model.addAttribute("korisnik", personDto);

            model.addAttribute("registerError", "Već postoji korisnik sa tim korisnickim imenom");

            System.out.println("Već postoji korisnik sa tim korisničkim imenom.");

            return "register";
        }
    }




}
