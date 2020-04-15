package com.teza.springpetclinic.services.springdatajpa;

import com.teza.springpetclinic.model.PetType;
import com.teza.springpetclinic.repositories.PetTypeRepository;
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
import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PetTypeSDJpaServiceTest {
    PetType returnedPetType;
    Long petTypeId = 1L;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    PetTypeSDJpaService service;


    @BeforeEach
    void setUp() {
        returnedPetType = PetType.builder().id(petTypeId).build();
    }

    @Test
    void findAll() {
//        given
        Set<PetType> petTypesSet = new HashSet<>();
        petTypesSet.add(PetType.builder().id(1L).build());
        petTypesSet.add(PetType.builder().id(2L).build());
//        when
        when(petTypeRepository.findAll()).thenReturn(petTypesSet);
        Set<PetType> petTypes = service.findAll();
//        then
        assertNotNull(petTypes);
        assertEquals(2, petTypes.size());
        verify(petTypeRepository, times(1)).findAll();

    }

    @Test
    void findById() {
        when(petTypeRepository.findById(any())).thenReturn(Optional.of(returnedPetType));
        PetType petType = service.findById(petTypeId);
        assertNotNull(petType);
        verify(petTypeRepository, times(1)).findById(any());
    }
    @Test
    void findByIdNotFound() {
        when(petTypeRepository.findById(any())).thenReturn(Optional.empty());
        PetType petType = service.findById(petTypeId);
        assertNull(petType);
        verify(petTypeRepository, times(1)).findById(any());
    }

    @Test
    void save() {
//        given
        PetType petTypeToBeSaved = PetType.builder().id(2L).build();
//        when
        when(petTypeRepository.save(any())).thenReturn(petTypeToBeSaved);
        PetType savedPetType = service.save(petTypeToBeSaved);
//        then
        assertNotNull(savedPetType);
//        default time is 1
        verify(petTypeRepository, times(1)).save(any());

    }

    @Test
    void delete() {
        service.delete(returnedPetType);
        verify(petTypeRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(returnedPetType.getId());
        verify(petTypeRepository, times(1)).deleteById(any());
    }
}