package com.teza.springpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "specialties")
public class Speciality extends BaseEntity {

    @Builder
    public Speciality(final Long id, final String description) {
        super(id);
        this.description = description;
    }

    @Column(name = "description")
    private String description;

    @Override
    public String toString() {
        return description;
    }
}
