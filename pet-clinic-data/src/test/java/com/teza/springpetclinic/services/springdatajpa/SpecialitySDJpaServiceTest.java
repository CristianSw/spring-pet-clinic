package com.teza.springpetclinic.services.springdatajpa;

import com.teza.springpetclinic.model.Speciality;
import com.teza.springpetclinic.repositories.SpecialityRepository;
import com.teza.springpetclinic.services.SpecialityService;
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
class SpecialitySDJpaServiceTest {

    public static final String DESCRIPTION = "Description";
    Speciality returnedSpecialty;
    Long specId = 1L;

    @Mock
    SpecialityRepository specialityRepository;
    @InjectMocks
    SpecialitySDJpaService service;

    @BeforeEach
    void setUp() {
        returnedSpecialty = Speciality.builder().id(specId).description(DESCRIPTION).build();
    }

    @Test
    void findAll() {
//        given
        Set<Speciality> specialitiesSet = new HashSet<>();
        specialitiesSet.add(Speciality.builder().id(1L).build());
        specialitiesSet.add(Speciality.builder().id(2L).build());
//        when
        when(specialityRepository.findAll()).thenReturn(specialitiesSet);
        Set<Speciality> specialities = service.findAll();
//        then
        assertEquals(2, specialities.size());
        verify(specialityRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        when(specialityRepository.findById(anyLong())).thenReturn(Optional.of(returnedSpecialty));
        Speciality speciality = service.findById(specId);
        assertNotNull(speciality);
        verify(specialityRepository, times(1)).findById(anyLong());
    }

    @Test
    void findByIdNotFound() {
//        when
        when(specialityRepository.findById(anyLong())).thenReturn(Optional.empty());
        Speciality speciality = service.findById(specId);
//        then
        assertNull(speciality);
        verify(specialityRepository, times(1)).findById(anyLong());
    }

    @Test
    void save() {
//        given
        Speciality speciality = Speciality.builder().id(1L).build();
//        when
        when(specialityRepository.save(any())).thenReturn(speciality);
        Speciality savedSpeciality = service.save(speciality);
//        then
        assertNotNull(savedSpeciality);
        verify(specialityRepository, times(1)).save(any());
    }

    @Test
    void delete() {
        service.delete(returnedSpecialty);
        verify(specialityRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(returnedSpecialty.getId());
        verify(specialityRepository, times(1)).deleteById(anyLong());
    }
}