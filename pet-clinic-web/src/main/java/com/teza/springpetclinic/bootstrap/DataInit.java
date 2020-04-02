package com.teza.springpetclinic.bootstrap;

import com.teza.springpetclinic.model.*;
import com.teza.springpetclinic.services.OwnerService;
import com.teza.springpetclinic.services.PetTypeService;
import com.teza.springpetclinic.services.SpecialityService;
import com.teza.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInit implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataInit(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Cristian");
        owner1.setLastName("Dolinta");
        owner1.setAddress("Tighina 2/3");
        owner1.setCity("Chisinau");
        owner1.setTelephone("+37379356922");

        Pet cristianPet = new Pet();
        cristianPet.setType(savedDogPetType);
        cristianPet.setOwner(owner1);
        cristianPet.setBirthDate(LocalDate.now());
        cristianPet.setName("Lulu");
        owner1.getPets().add(cristianPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Daniela");
        owner2.setLastName("Tanas");
        owner2.setAddress("Some Street");
        owner2.setCity("Balabanesti");
        owner2.setTelephone("+37379356933");

        Pet danielaPet = new Pet();
        danielaPet.setType(savedCatPetType);
        danielaPet.setOwner(owner2);
        danielaPet.setBirthDate(LocalDate.now());
        danielaPet.setName("Mia");
        owner2.getPets().add(danielaPet);
        ownerService.save(owner2);

        System.out.println("Owners loaded !");

        Vet vet1 = new Vet();
        vet1.setFirstName("John");
        vet1.setLastName("Deere");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Michael");
        vet2.setLastName("Jilehovschi");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Alexander");
        vet3.setLastName("Hulk");
        vet3.getSpecialities().add(savedRadiology);

        System.out.println("Vets loaded !");
    }
}
