package com.teza.springpetclinic.controllers;

import com.teza.springpetclinic.model.PetType;
import com.teza.springpetclinic.model.Speciality;
import com.teza.springpetclinic.model.Vet;
import com.teza.springpetclinic.services.SpecialityService;
import com.teza.springpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RequestMapping({"/vets.html"})
@Controller
public class VetController {
    private final VetService vetService;

    private static final String VIEWS_VETS_CREATE_OR_UPDATE_FORM = "/vets/createOrUpdateVet";
    public VetController(VetService vetService, SpecialityService specialityService) {
        this.vetService = vetService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOfVets(Model model) {

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
    @GetMapping("/api/vets")
    public @ResponseBody Set<Vet> getVetsJson(){

        return vetService.findAll();
    }
}
