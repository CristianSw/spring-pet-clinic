package com.teza.springpetclinic.bootstrap;

import com.teza.springpetclinic.model.Owner;
import com.teza.springpetclinic.model.Pet;
import com.teza.springpetclinic.model.PetType;
import com.teza.springpetclinic.model.Vet;
import com.teza.springpetclinic.services.OwnerService;
import com.teza.springpetclinic.services.PetTypeService;
import com.teza.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataInit(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Cristian");
        owner1.setLastName("Dolinta");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Daniela");
        owner2.setLastName("Tanas");
        ownerService.save(owner2);

        System.out.println("Owners loaded !");

        Vet vet1 = new Vet();
        vet1.setFirstName("John");
        vet1.setLastName("Deere");

        vetService.save(vet1);
        ;

        Vet vet2 = new Vet();
        vet2.setFirstName("Michael");
        vet2.setLastName("Jilehovschi");
        vetService.save(vet2);

        System.out.println("Vets loaded !");
    }
}
