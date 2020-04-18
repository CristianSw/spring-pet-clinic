package com.teza.springpetclinic.controllers;

import com.teza.springpetclinic.model.Owner;
import com.teza.springpetclinic.model.PetType;
import com.teza.springpetclinic.services.OwnerService;
import com.teza.springpetclinic.services.PetService;
import com.teza.springpetclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.Set;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {
    private static final String VIEW_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdateForm";
    private final PetService petService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;

    public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }

    @ModelAttribute("petType")
    public Set<PetType> populatePetTypes(){
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable Long ownerId){
        return ownerService.findById(ownerId);
    }
    @InitBinder("owner")
    public void initBinderOwner(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");
    }


}
