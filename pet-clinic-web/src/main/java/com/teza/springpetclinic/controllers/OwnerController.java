package com.teza.springpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {
    @RequestMapping({"/owners","owners/index","owners/index.html"})
    public String listOfVets(){
        return "owners/index";
    }
}
