package com.example.projectspring.model.rocketLeague;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table

public class Quality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated
    private ItemQuality nameQuality;
    @ManyToMany
    @JsonBackReference

    @JoinTable( name = "T_Item_Quality_Associations",
            joinColumns = @JoinColumn( name = "idQuality" ),
            inverseJoinColumns = @JoinColumn( name = "idItem" ) )
    private Set<Item> itemSet;

    public long getId() {
        return id;
    }

    public ItemQuality getNameQuality() {
        return nameQuality;
    }

    public Set<Item> getItemSet() {
        return itemSet;
    }
}
