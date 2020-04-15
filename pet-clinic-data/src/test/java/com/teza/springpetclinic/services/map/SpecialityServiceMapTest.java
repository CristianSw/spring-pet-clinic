package com.teza.springpetclinic.services.map;

import com.teza.springpetclinic.model.Speciality;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SpecialityServiceMapTest {
    SpecialityServiceMap specialityServiceMap;
    Long specId = 1L;

    @BeforeEach
    void setUp() {
        specialityServiceMap = new SpecialityServiceMap();
        specialityServiceMap.save(Speciality.builder().id(specId).build());
    }

    @Test
    void findAll() {
        Set<Speciality> specialities = specialityServiceMap.findAll();
        assertEquals(1, specialities.size());
    }

    @Test
    void deleteById() {
        specialityServiceMap.deleteById(specialityServiceMap.findById(specId).getId());
        assertEquals(0, specialityServiceMap.findAll().size());
    }

    @Test
    void delete() {
        specialityServiceMap.delete(specialityServiceMap.findById(specId));
        assertEquals(0, specialityServiceMap.findAll().size());
    }

    @Test
    void save() {
        Long id = 2L;
        specialityServiceMap.save(Speciality.builder().id(id).build());
        assertEquals(2,specialityServiceMap.findAll().size());
    }

    @Test
    void findById() {
        Speciality specialities =  specialityServiceMap.findById(specId);
        assertEquals(specialities.getId(),specialityServiceMap.findById(specId).getId());
    }
}