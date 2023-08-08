package com.example.projectspring.model.rocketLeague;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

/*
* POUR EVITER LA LOOP INFINI DES OBJETS
* Dans la classe principale : rajouter     @JsonManagedReference
* Dans la classe "enfant" : rajouter @JsonBackReference
 * */
@Entity
@Table(name = "Item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String itemName;

    @ManyToMany
    @Enumerated
    @JsonManagedReference
    @JoinTable( name = "T_Item_Certification_Associations",
            joinColumns = @JoinColumn( name = "idItem" ),
            inverseJoinColumns = @JoinColumn( name = "idCertification" ) )
    private Set<Certification> certificationSet;
    @Enumerated
    @ManyToMany
    @JsonManagedReference

    @JoinTable( name = "T_Item_Color_Associations",
            joinColumns = @JoinColumn( name = "idItem" ),
            inverseJoinColumns = @JoinColumn( name = "idColor" ) )
    private Set<Color> colorSet;
    @ManyToMany
    @Enumerated
    @JsonManagedReference

    @JoinTable( name = "T_Item_Quality_Associations",
            joinColumns = @JoinColumn( name = "idItem" ),
            inverseJoinColumns = @JoinColumn( name = "idQuality" ) )
    private Set<Quality> qualitySet;

    @ManyToMany
    @Enumerated
    @JsonManagedReference
    @JoinTable( name = "T_Item_Plateforms_Associations",
            joinColumns = @JoinColumn( name = "idItem" ),
            inverseJoinColumns = @JoinColumn( name = "idPlateforms" ) )
    private Set<Platefroms> platefromsSet;

    @ManyToMany
    @Enumerated
    @JsonManagedReference
    @JoinTable( name = "T_Item_Type_Associations",
            joinColumns = @JoinColumn( name = "idItem" ),
            inverseJoinColumns = @JoinColumn( name = "idType" ) )
    private Set<Type> typeSet;



    private int averagePrice;


    public long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public Set<Certification> getCertificationSet() {
        return certificationSet;
    }

    public Set<Color> getColorSet() {
        return colorSet;
    }

    public Set<Type> getTypeSet() {
        return typeSet;
    }

    public Set<Quality> getQualitySet() {
        return qualitySet;
    }

    public Set<Platefroms> getPlatefromsSet() {
        return platefromsSet;
    }

    public int getAveragePrice() {
        return averagePrice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", certificationSet=" + certificationSet +
                ", colorSet=" + colorSet +
                ", qualitySet=" + qualitySet +
                ", platefromsSet=" + platefromsSet +
                ", averagePrice=" + averagePrice +
                '}';
    }
}
