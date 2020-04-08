package com.teza.springpetclinic.controllers;

import com.teza.springpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"/vets.html"})
@Controller
public class VetController {
    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOfVets(Model model) {

        model.addAttribute("vets",vetService.findAll());

        return "vets/index";
    }
}
