package com.teza.springpetclinic.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

    @Builder
    public Pet(final Long id, final String name, final PetType PetType, final LocalDate birthDate, final Owner owner,
               final Set<Visit> visits) {
        super(id);
        this.name = name;
        this.PetType = PetType;
        this.birthDate = birthDate;
        this.owner = owner;
        if (visits == null || visits.size() >0) {
            this.visits = visits;
        }
    }

    @Column(name = "name")
    @NotEmpty
    private String name;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType PetType;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();
}
