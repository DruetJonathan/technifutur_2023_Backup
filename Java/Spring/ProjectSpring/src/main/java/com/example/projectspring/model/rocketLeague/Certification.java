package com.example.projectspring.model.rocketLeague;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Certification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated
    private ItemCertification nameCertification;
    @ManyToMany
    @JsonBackReference
    @JoinTable( name = "T_Item_Certification_Associations",
            joinColumns = @JoinColumn( name = "idCertification" ),
            inverseJoinColumns = @JoinColumn( name = "idItem" ) )
    private Set<Item> itemSet;

    public long getId() {
        return id;
    }

    public ItemCertification getNameCertification() {
        return nameCertification;
    }

    public Set<Item> getItemSet() {
        return itemSet;
    }
}
