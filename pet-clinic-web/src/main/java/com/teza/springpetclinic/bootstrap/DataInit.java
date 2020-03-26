package com.teza.springpetclinic.bootstrap;

import com.teza.springpetclinic.model.Owner;
import com.teza.springpetclinic.model.Vet;
import com.teza.springpetclinic.services.OwnerService;
import com.teza.springpetclinic.services.VetService;
import com.teza.springpetclinic.services.map.OwnerServiceMap;
import com.teza.springpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;

public class DataInit implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataInit() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Cristian");
        owner1.setLastName("Dolinta");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Daniela");
        owner2.setLastName("Tanas");
        ownerService.save(owner2);

        System.out.println("Owners loaded !");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("John");
        vet1.setLastName("Deere");

        vetService.save(vet1);;

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Michael");
        vet2.setLastName("Jilehovschi");
        vetService.save(vet2);

        System.out.println("Vets loaded !");
    }
}
