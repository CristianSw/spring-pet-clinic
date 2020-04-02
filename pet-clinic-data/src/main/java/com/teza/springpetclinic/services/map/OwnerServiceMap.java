package com.teza.springpetclinic.services.map;

import com.teza.springpetclinic.model.Owner;
import com.teza.springpetclinic.model.Pet;
import com.teza.springpetclinic.services.OwnerService;
import com.teza.springpetclinic.services.PetService;
import com.teza.springpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(final Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(final Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(final Owner object) {

        Owner savedOwner = null;
        if (object != null) {
            if (object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if (pet.getType() != null){
                        if (pet.getType().getId() != null){
                            pet.setType(petTypeService.save(pet.getType()));
                        }
                    }else {
                        throw new RuntimeException("Pet Type is required !");
                    }

                    if (pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        } else return null;
    }

    @Override
    public Owner findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(final String lastName) {
        return null;
    }
}
