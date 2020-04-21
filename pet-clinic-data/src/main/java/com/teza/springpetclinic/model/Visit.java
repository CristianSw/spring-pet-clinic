package com.teza.springpetclinic.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "visit")
public class Visit extends BaseEntity {

    @Builder
    public Visit(final Long id, final LocalDate date, final String description, final Pet pet){
        super(id);
        this.date = date;
        this.description = description;
        this.pet = pet;
    }

    @Column(name = "local_date")
    private LocalDate date;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
}
