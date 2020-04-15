package com.teza.springpetclinic.services.springdatajpa;

import com.teza.springpetclinic.model.Vet;
import com.teza.springpetclinic.repositories.VetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.ManyToOne;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {

    private final String LAST_NAME = "Vet";
    Long vetId = 1L;
    Vet returnedVet;

    @Mock
    VetRepository vetRepository;
    @InjectMocks
    VetSDJpaService service;

    @BeforeEach
    void setUp() {
        returnedVet = Vet.builder().id(vetId).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(vetRepository.findByLastName(any())).thenReturn(returnedVet);
        Vet vet = service.findByLastName(LAST_NAME);
        assertNotNull(vet);
        assertEquals(LAST_NAME, vet.getLastName());
        verify(vetRepository, times(1)).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Vet> vets = new HashSet<>();
        vets.add(Vet.builder().id(1L).build());
        vets.add(Vet.builder().id(2L).build());

        when(vetRepository.findAll()).thenReturn(vets);
        Set<Vet> findVets = service.findAll();
        assertNotNull(findVets);
        assertEquals(2, findVets.size());
        verify(vetRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        when(vetRepository.findById(any())).thenReturn(Optional.of(returnedVet));
        Vet vet1 = service.findById(vetId);
        assertNotNull(vet1);
        verify(vetRepository, times(1)).findById(any());
    }

    @Test
    void findByIdNotFound() {
        when(vetRepository.findById(any())).thenReturn(Optional.empty());
        Vet vet1 = service.findById(vetId);
        assertNull(vet1);
        verify(vetRepository, times(1)).findById(any());
    }

    @Test
    void save() {
        Vet vetToBeSaved = Vet.builder().id(1L).build();
        when(vetRepository.save(any())).thenReturn(vetToBeSaved);
        Vet savedVet = service.save(vetToBeSaved);

        assertNotNull(savedVet);
        assertEquals(vetToBeSaved.getId(), savedVet.getId());
        verify(vetRepository, times(1)).save(any());
    }

    @Test
    void delete() {
        service.delete(returnedVet);
        verify(vetRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(returnedVet.getId());
        verify(vetRepository, times(1)).deleteById(any());
    }
}