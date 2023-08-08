package com.example.projectspring.model.car;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Brand(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "brand")
    private Set<Car> car;

    public Brand() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
