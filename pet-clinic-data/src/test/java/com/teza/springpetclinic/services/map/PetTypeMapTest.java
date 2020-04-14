package com.teza.springpetclinic.services.map;

import com.teza.springpetclinic.model.PetType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetTypeMapTest {
    PetTypeMap petTypeMap;
    Long petTypeId = 1L;

    @BeforeEach
    void setUp() {
        petTypeMap = new PetTypeMap();
        petTypeMap.save(PetType.builder().id(petTypeId).build());
    }

    @Test
    void findAll() {
        Set<PetType> petTypes = petTypeMap.findAll();
        assertEquals(1, petTypes.size());
    }

    @Test
    void deleteById() {
        petTypeMap.deleteById(petTypeMap.findById(petTypeId).getId());
        assertEquals(0, petTypeMap.findAll().size());
    }

    @Test
    void delete() {
        petTypeMap.delete(petTypeMap.findById(petTypeId));
        assertEquals(0, petTypeMap.findAll().size());
    }

    @Test
    void save() {
        Long id = 2L;
        petTypeMap.save(PetType.builder().id(id).build());
        assertEquals(2,petTypeMap.findAll().size());
    }

    @Test
    void findById() {
        PetType pet = petTypeMap.findById(petTypeId);
        assertEquals(pet.getId(),petTypeMap.findById(petTypeId).getId());
    }
}