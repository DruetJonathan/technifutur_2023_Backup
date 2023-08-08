package com.example.projectspring.model.rocketLeague;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table

public class Platefroms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated
    private ItemPlatefroms namePlateform;
    @ManyToMany
    @JsonBackReference

    @JoinTable( name = "T_Item_Plateforms_Associations",
            joinColumns = @JoinColumn( name = "idPlateforms" ),
            inverseJoinColumns = @JoinColumn( name = "idItem" ) )
    private Set<Item> itemSet;

    public long getId() {
        return id;
    }

    public ItemPlatefroms getNamePlateform() {
        return namePlateform;
    }

    public Set<Item> getItemSet() {
        return itemSet;
    }
}
