package com.teza.springpetclinic.bootstrap;

import com.teza.springpetclinic.model.*;
import com.teza.springpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInit implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataInit(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                    SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
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
        dog.setName("Câine");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Pisică");
        PetType savedCatPetType = petTypeService.save(cat);

        PetType hamster = new PetType();
        hamster.setName("Hamster");
        PetType savedHamsterType = petTypeService.save(hamster);

        PetType turtle = new PetType();
        turtle.setName("Broască Ţistoasă");
        PetType savedTurtleType = petTypeService.save(turtle);

        PetType snake = new PetType();
        snake.setName("Şarpe");
        PetType savedSnakeType = petTypeService.save(snake);

        PetType hedgehong = new PetType();
        hedgehong.setName("Arici");
        PetType savedHedgehongType = petTypeService.save(hedgehong);



        Speciality radiology = new Speciality();
        radiology.setDescription("Radiolog");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Chirurg");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentist");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Cristian");
        owner1.setLastName("Dolinta");
        owner1.setAddress("Tighina 2/3");
        owner1.setCity("Chisinau");
        owner1.setTelephone("+37379356922");

        Pet cristianPet = new Pet();
        cristianPet.setPetType(savedDogPetType);
        cristianPet.setOwner(owner1);
        cristianPet.setBirthDate(LocalDate.now());
        cristianPet.setName("Lulu");
        owner1.getPets().add(cristianPet);
        ownerService.save(owner1);

        Visit visitDog = new Visit();
        visitDog.setPet(cristianPet);
        visitDog.setDate(LocalDate.now());
        visitDog.setDescription("Dog has eat something wrong.");
        visitService.save(visitDog);

        Owner owner2 = new Owner();
        owner2.setFirstName("Daniela");
        owner2.setLastName("Dolinta");
        owner2.setAddress("Some Street");
        owner2.setCity("Balabanesti");
        owner2.setTelephone("+37379356933");

        Pet danielaPet = new Pet();
        danielaPet.setPetType(savedCatPetType);
        danielaPet.setOwner(owner2);
        danielaPet.setBirthDate(LocalDate.now());
        danielaPet.setName("Mia");
        owner2.getPets().add(danielaPet);
        ownerService.save(owner2);

        Visit visitCat = new Visit();
        visitCat.setPet(danielaPet);
        visitCat.setDate(LocalDate.now());
        visitCat.setDescription("Cat has eat something wrong.");
        visitService.save(visitCat);

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
        vet3.getSpecialities().add(savedDentistry);
        vetService.save(vet3);

        System.out.println("Vets loaded !");
    }
}
