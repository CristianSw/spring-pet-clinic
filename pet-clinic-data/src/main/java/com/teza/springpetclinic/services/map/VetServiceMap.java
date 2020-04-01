package com.teza.springpetclinic.services.map;

import com.teza.springpetclinic.model.Vet;
import com.teza.springpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(final Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(final Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(final Vet object) {
        return super.save(object);
    }

    @Override
    public Vet findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public Vet findByLastName(final String lastName) {
        return null;
    }
}
