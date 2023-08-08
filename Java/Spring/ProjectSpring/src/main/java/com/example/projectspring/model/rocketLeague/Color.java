package com.example.projectspring.model.rocketLeague;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated
    private ItemColor nameColor;
    @ManyToMany
    @JsonBackReference
    @JoinTable( name = "T_Item_Color_Associations",
            joinColumns = @JoinColumn( name = "idColor" ),
            inverseJoinColumns = @JoinColumn( name = "idItem" ) )
    private Set<Item> itemSet;

    public Long getId() {
        return id;
    }

    public ItemColor getNameColor() {
        return nameColor;
    }

    public Set<Item> getItemSet() {
        return itemSet;
    }
}
