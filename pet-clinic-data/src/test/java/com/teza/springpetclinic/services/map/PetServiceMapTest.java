package com.teza.springpetclinic.services.map;

import com.teza.springpetclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetServiceMapTest {
    PetServiceMap petServiceMap;
    Long petId = 1L;

    @BeforeEach
    void setUp() {
        petServiceMap = new PetServiceMap();
        petServiceMap.save(Pet.builder().id(petId).build());
    }

    @Test
    void findAll() {
        Set<Pet> pets = petServiceMap.findAll();
        assertEquals(1,pets.size());
    }

    @Test
    void deleteById() {
        petServiceMap.deleteById(petServiceMap.findById(petId).getId());
        assertEquals(0,petServiceMap.findAll().size());
    }

    @Test
    void delete() {
        petServiceMap.delete(petServiceMap.findById(petId));
        assertEquals(0,petServiceMap.findAll().size());
    }

    @Test
    void save() {
        Long id = 2L;
        petServiceMap.save(Pet.builder().id(id).build());
        assertEquals(2,petServiceMap.findAll().size());
    }

    @Test
    void findById() {
        Pet pet = petServiceMap.findById(petId);
        assertEquals(petId,pet.getId());
    }
}