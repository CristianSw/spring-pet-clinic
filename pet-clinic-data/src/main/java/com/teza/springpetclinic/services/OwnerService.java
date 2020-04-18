package com.teza.springpetclinic.services;

import com.teza.springpetclinic.model.Owner;

import java.util.List;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(final String lastName);

    List<Owner> findAllByLastNameLike(final String lastName);
}
