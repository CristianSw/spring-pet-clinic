package com.teza.springpetclinic.services.map;

import com.teza.springpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(final ID id) {
        return map.get(id);
    }

    T save(final T object) {
        if (object!=null){
            if (object.getId() == null){
                object.setId(getNexId());
            }
            map.put(object.getId(),object);
        }else {
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }

    void deleteById(final ID id) {
        map.remove(id);
    }

    void delete(final T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }
    private Long getNexId(){
        Long nextId = null;
       try {
           nextId = Collections.max(map.keySet()) + 1;
       }catch (NoSuchElementException e){
           nextId = 1L;
       }
       return nextId;
    }
}
