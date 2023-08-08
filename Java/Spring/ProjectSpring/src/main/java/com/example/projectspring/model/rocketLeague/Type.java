package com.example.projectspring.model.rocketLeague;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Set;
@Entity
@Table
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated
    private ItemType nameType;
    @ManyToMany
    @JsonBackReference
    @JoinTable( name = "T_Item_Type_Associations",
            joinColumns = @JoinColumn( name = "idType" ),
            inverseJoinColumns = @JoinColumn( name = "idItem" ) )
    private Set<Item> itemSet;

    public Long getId() {
        return id;
    }

    public ItemType getNameType() {
        return nameType;
    }

    public Set<Item> getItemSet() {
        return itemSet;
    }
}
