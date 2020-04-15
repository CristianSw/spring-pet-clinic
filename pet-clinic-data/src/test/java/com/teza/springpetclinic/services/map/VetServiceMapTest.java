package com.teza.springpetclinic.services.map;

import com.teza.springpetclinic.model.Speciality;
import com.teza.springpetclinic.model.Vet;
import com.teza.springpetclinic.services.SpecialityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VetServiceMapTest {
    VetServiceMap vetServiceMap;
    Long vetId = 1L;
    String lastName = "Doctor";
    Set<Speciality> specialities = new HashSet<>();


    @BeforeEach
    void setUp() {
        vetServiceMap = new VetServiceMap(new SpecialityServiceMap());
        specialities.add(new Speciality());
        vetServiceMap.save(Vet.builder().id(vetId).lastName(lastName).specialities(specialities).build());
    }

    @Test
    void findAll() {
        Set<Vet> vets = vetServiceMap.findAll();
        assertEquals(vetId,vets.size());
    }

    @Test
    void deleteById() {
        vetServiceMap.deleteById(vetServiceMap.findById(vetId).getId());
        assertEquals(0,vetServiceMap.findAll().size());
    }

    @Test
    void delete() {
        vetServiceMap.delete(vetServiceMap.findById(vetId));
        assertEquals(0,vetServiceMap.findAll().size());
    }

    @Test
    void save() {
        Long id = 2L;
        Set<Speciality> speciality2 = new HashSet<>();
        speciality2.add(new Speciality());
        vetServiceMap.save(Vet.builder().id(id).specialities(speciality2).build());
        assertEquals(2, vetServiceMap.findAll().size());
    }

    @Test
    void findById() {
        Vet vet2= vetServiceMap.findById(vetId);
        assertEquals(vet2.getId(),vetServiceMap.findById(vetId).getId());
    }

    @Test
    void findByLastName() {
        Vet doctor = vetServiceMap.findByLastName(lastName);
        assertNotNull(doctor);
        assertEquals(lastName,doctor.getLastName());
    }
}