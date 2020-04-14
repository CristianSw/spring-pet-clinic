package com.teza.springpetclinic.services.map;

import com.teza.springpetclinic.model.Owner;
import com.teza.springpetclinic.services.PetService;
import com.teza.springpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {
    OwnerServiceMap ownerServiceMap;
    final Long ownerId = 1L;
    final String lastName = "Dolinta";


    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeMap(),new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertEquals(ownerId,ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerServiceMap.findById(ownerId).getId());
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();
        Owner savedOwner = ownerServiceMap.save(owner2);
        assertEquals(id,savedOwner.getId());
    }
    @Test
    void saveNoId(){
        Owner savedOwner = ownerServiceMap.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);
        assertEquals(ownerId,owner.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner dolinta = ownerServiceMap.findByLastName("lastName");
        assertNull(dolinta);
    }
    @Test
    void findByLastName() {
        Owner dolinta = ownerServiceMap.findByLastName(lastName);
        assertNotNull(dolinta);
        assertEquals(lastName,dolinta.getLastName());
    }
}