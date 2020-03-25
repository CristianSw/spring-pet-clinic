package com.teza.springpetclinic.services;

import java.util.Set;

public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(final ID id);

    T save(final T object);

    void delete(final T object);

    void deleteById(final ID id);
}
