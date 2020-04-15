package com.teza.springpetclinic.services.springdatajpa;

import com.teza.springpetclinic.model.Visit;
import com.teza.springpetclinic.repositories.VisitRepository;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    Long visitId = 1L;
    Visit returnedVisit;

    @Mock
    VisitRepository visitRepository;
    @InjectMocks
    VisitSDJpaService service;

    @BeforeEach
    void setUp() {
        returnedVisit = Visit.builder().id(visitId).build();
    }

    @Test
    void findAll() {
        Set<Visit> visitsSet = new HashSet<>();
        visitsSet.add(Visit.builder().id(1L).build());
        visitsSet.add(Visit.builder().id(2L).build());

        when(visitRepository.findAll()).thenReturn(visitsSet);
        Set<Visit> visits = service.findAll();

        assertNotNull(visits);
        assertEquals(2, visits.size());
        verify(visitRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        when(visitRepository.findById(anyLong())).thenReturn(Optional.of(returnedVisit));
        Visit visit = service.findById(visitId);

        assertNotNull(visit);
        assertEquals(visitId, visit.getId());
        verify(visitRepository, times(1)).findById(anyLong());
    }

    @Test
    void findByIdNotFound() {
        when(visitRepository.findById(anyLong())).thenReturn(Optional.empty());
        Visit visit = service.findById(visitId);

        assertNull(visit);
        verify(visitRepository, times(1)).findById(anyLong());
    }

    @Test
    void save() {
        Visit visit = Visit.builder().id(1L).build();

        when(visitRepository.save(any())).thenReturn(visit);
        Visit savedVisit = service.save(visit);

        assertNotNull(savedVisit);
        assertEquals(visit.getId(), savedVisit.getId());
        verify(visitRepository, times(1)).save(any());
    }

    @Test
    void delete() {
        service.delete(returnedVisit);
        verify(visitRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(visitId);
        verify(visitRepository, times(1)).deleteById(anyLong());
    }
}