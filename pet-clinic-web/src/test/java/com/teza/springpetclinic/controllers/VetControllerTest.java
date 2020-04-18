package com.teza.springpetclinic.controllers;


import com.teza.springpetclinic.model.Vet;
import com.teza.springpetclinic.services.VetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class VetControllerTest {

    @Mock
    com.teza.springpetclinic.services.VetService vetService;
    @InjectMocks
    VetController controller;
    Set<com.teza.springpetclinic.model.Vet> vet;
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        vet = new HashSet<>();
        vet.add(Vet.builder().id(1L).build());
        vet.add(Vet.builder().id(2L).build());
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void listOfVets() throws Exception {
        when(vetService.findAll()).thenReturn(vet);
        mockMvc.perform(get("/vets.html"))
                .andExpect(status().isOk())
                .andExpect(view().name("vets/index"))
                .andExpect(model().attribute("vets", hasSize(2)));
    }

    @Test
    void listOfVetsSlash() throws Exception {
        when(vetService.findAll()).thenReturn(vet);
        mockMvc.perform(get("/vets.html/"))
                .andExpect(status().isOk())
                .andExpect(view().name("vets/index"))
                .andExpect(model().attribute("vets", hasSize(2)));
    }

    @Test
    void listOfVetsIndex() throws Exception {
        when(vetService.findAll()).thenReturn(vet);
        mockMvc.perform(get("/vets.html/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("vets/index"))
                .andExpect(model().attribute("vets", hasSize(2)));
    }

    @Test
    void listOfVetsIndexHTML() throws Exception {
        when(vetService.findAll()).thenReturn(vet);
        mockMvc.perform(get("/vets.html/index.html"))
                .andExpect(status().isOk())
                .andExpect(view().name("vets/index"))
                .andExpect(model().attribute("vets", hasSize(2)));
    }
}