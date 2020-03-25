package com.teza.springpetclinic.services;

import com.teza.springpetclinic.model.Vet;

public interface VetService extends CrudService<Vet, Long> {
    Vet findByLastName(String lastName);

}
