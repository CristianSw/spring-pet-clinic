package com.teza.springpetclinic.services.springdatajpa;

import com.teza.springpetclinic.model.Pet;
import com.teza.springpetclinic.repositories.PetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PetSDJpaServiceTest {
    Pet returnPet;
    Long petId = 1L;
    @Mock
    PetRepository petRepository;
    @InjectMocks
    PetSDJpaService service;

    @BeforeEach
    void setUp() {
        returnPet = Pet.builder().id(petId).build();
    }

    @Test
    void findAll() {
//        given
        Set<Pet> returnedPetsSet = new HashSet<>();
        returnedPetsSet.add(Pet.builder().id(1L).build());
        returnedPetsSet.add(Pet.builder().id(2L).build());
//        when
        when(petRepository.findAll()).thenReturn(returnedPetsSet);
        Set<Pet> pets = service.findAll();
//        then
        assertNotNull(pets);
        assertEquals(2, pets.size());
        verify(petRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        when(petRepository.findById(any())).thenReturn(Optional.of(returnPet));
        Pet pet = service.findById(petId);
        assertNotNull(pet);
        verify(petRepository, times(1)).findById(any());
    }

    @Test
    void findByIdNotFound() {
        when(petRepository.findById(any())).thenReturn(Optional.empty());
        Pet pet = service.findById(petId);
        assertNull(pet);
        verify(petRepository, times(1)).findById(any());
    }

    @Test
    void save() {
//        given
        Pet petToBeSaved = Pet.builder().id(2L).build();
//        when
        when(petRepository.save(any())).thenReturn(petToBeSaved);
        Pet savedPet = service.save(petToBeSaved);
//        then
        assertNotNull(savedPet);
        verify(petRepository, times(1)).save(any());
    }

    @Test
    void delete() {
        service.delete(returnPet);
        verify(petRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(petId);
        verify(petRepository, times(1)).deleteById(any());
    }
}