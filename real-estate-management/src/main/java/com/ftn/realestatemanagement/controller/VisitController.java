package com.ftn.realestatemanagement.controller;

import com.ftn.realestatemanagement.dto.VisitDto;
import com.ftn.realestatemanagement.dto.VisitRequestDto;
import com.ftn.realestatemanagement.model.VisitRequest;
import com.ftn.realestatemanagement.service.VisitService;
import com.ftn.realestatemanagement.service.impl.VisitServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/visits")
public class VisitController {

    private final VisitService visitService;
    @PostMapping("/add")
    public String createVisit(@ModelAttribute VisitRequestDto visitRequestDtoDto) {
        visitService.bookVisit(visitRequestDtoDto);
        return "redirect:/";
    }

}
