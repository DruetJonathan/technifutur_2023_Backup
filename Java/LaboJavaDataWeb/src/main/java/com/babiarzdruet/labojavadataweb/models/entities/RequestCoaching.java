package com.babiarzdruet.labojavadataweb.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Table(name = "Request Coaching")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class RequestCoaching implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 50)
    String name;

    @Column(length = 250)
    String description;

    @Column
    Integer price;

    @Column
    String image;

    @OneToOne(cascade = CascadeType.MERGE)
    Game game;

    @ManyToOne(cascade = CascadeType.MERGE)
    User user;



    @Column
    Boolean pending = true;

    public RequestCoaching(String name, String description, Integer price, String image, Game game, User user) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.game = game;
        this.user = user;
    }
}
