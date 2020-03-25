package com.teza.springpetclinic.services;

import com.teza.springpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
