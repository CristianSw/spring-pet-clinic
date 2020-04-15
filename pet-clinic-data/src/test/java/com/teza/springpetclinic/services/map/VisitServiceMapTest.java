package com.teza.springpetclinic.services.map;

import com.teza.springpetclinic.model.Owner;
import com.teza.springpetclinic.model.Pet;
import com.teza.springpetclinic.model.PetType;
import com.teza.springpetclinic.model.Visit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VisitServiceMapTest {

    VisitServiceMap visitServiceMap;
    Long visitId = 1L;
    PetServiceMap petServiceMap = new PetServiceMap();
    Long petId = 2L;
    String petName = "SomePetName";


    @BeforeEach
    void setUp() {
        visitServiceMap = new VisitServiceMap();
        Pet pet = petServiceMap.save(Pet.builder().id(petId).owner(Owner.builder().id(21L).build()).name(petName).build());
        visitServiceMap.save(Visit.builder().id(visitId).pet(pet).build());
    }

    @Test
    void findAll() {
        Set<Visit> visitSet = visitServiceMap.findAll();
        assertEquals(1, visitSet.size());
    }

    @Test
    void deleteById() {
        visitServiceMap.deleteById(visitId);
        assertEquals(0, visitServiceMap.findAll().size());
    }

    @Test
    void delete() {
        visitServiceMap.delete(visitServiceMap.findById(visitId));
        assertEquals(0, visitServiceMap.findAll().size());
    }

    @Test
    void save() {
        Long id = 2L;
        Long petId = 3L;
        Pet pet2 = petServiceMap.save(Pet.builder().id(petId).owner(Owner.builder().id(petId).build()).name("SomeName").build());
        Visit visit = visitServiceMap.save(Visit.builder().id(id).pet(pet2).build());
        assertEquals(2, visitServiceMap.findAll().size());
    }

    @Test
    void findById() {
        Visit visit = visitServiceMap.findById(visitId);
        assertEquals(visitId, visit.getId());
    }
}